package pat.project.challengehack.services.websocket

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import basic.data.webRtc.AudioHandler
import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import basics.WebRtcSocketProvider
import impl.data.managers.WebRtcSessionManager
import impl.data.providers.WebRtcDataConnector
import impl.data.providers.WebsocketStompDataConnector
import impl.data.stomp.StompWebsocketProviderImpl
import impl.data.webRtc.StreamPeerConnectionFactory
import impl.data.webRtc.WebRtcSessionManagerImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import pat.project.challengehack.services.audio.handlers.AudioSwitchHandler
import websockets.basics.StompWebsocketProvider
import javax.inject.Inject

class WebsocketService() : Service(), WebsocketStompDataConnector, WebRtcDataConnector {
    // Binder given to clients.
    private val binder = LocalBinder()

    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods.
        fun getService(): WebsocketService = this@WebsocketService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    @Inject
    lateinit var stompWebsocketProviderImpl: StompWebsocketProviderImpl

    private val stompWebsocketProvider : StompWebsocketProvider by lazy{
        stompWebsocketProviderImpl
    }

    private val stompWebRtcProvider : WebRtcSocketProvider by lazy{
        stompWebsocketProviderImpl
    }


    private val audioHandler: AudioHandler = AudioSwitchHandler(this@WebsocketService)
    private val streamPeerConnectionFactory = StreamPeerConnectionFactory(this@WebsocketService)

    override val sessionManager : WebRtcSessionManager by lazy {
        WebRtcSessionManagerImpl(
            this@WebsocketService,
            audioHandler = audioHandler,
            signalingClient = stompWebRtcProvider,
            peerConnectionFactory = streamPeerConnectionFactory

        )
    }

    override var messageFlow: Flow<WebsocketMessageReceivedEntity> = flowOf()

    override fun initStompWebsocket() {
        messageFlow = stompWebsocketProvider.messageFlow
        stompWebsocketProvider.connect()
    }

    override fun reconnectStompWebsocket() {
        stompWebsocketProvider.reconnect()
    }

    override fun disconnectStompWebsocket() {
        stompWebsocketProvider.disconnect()
    }

    override fun sendMessageInChat(chatId: Int, message: WebsocketMessageSendEntity) {
        stompWebsocketProvider.sendMessage(chatId, message)
    }

    override fun connectToChatToListening(chatId: Int) {
        stompWebsocketProvider.subscribeOnChat(chatId)
    }

    override fun disconnectFromChat() {
        stompWebsocketProvider.disconnectFromChat()
    }

    ////////////////   WebRtc
    override fun connectToWebRtc() {
        stompWebRtcProvider.connectWebRtc(1)
        serviceScope.launch {
            sessionManager.signalingClient.sessionStateFlow.collectLatest {sessionState ->
                Log.i("sessionState", sessionState.name)
            }

            sessionManager.signalingClient.signalingCommandFlow.collectLatest { signalingCommandFlow ->
                Log.i("signalingCommandFlow", signalingCommandFlow.first.name)
            }
        }

    }

    override fun disconnectWebRtc() {
        TODO("Not yet implemented")
    }
}