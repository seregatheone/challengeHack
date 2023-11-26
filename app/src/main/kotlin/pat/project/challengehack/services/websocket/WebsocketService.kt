package pat.project.challengehack.services.websocket

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import android.util.Log
import basic.data.webRtc.AudioHandler
import basic.domain.genre.interactors.GenreInteractor
import basic.domain.room.interactors.RoomInteractor
import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import basics.WebRtcSocketProvider
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsManifest
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import common.domain.entity.Entity
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
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
import kotlinx.coroutines.withContext
import pat.project.challengehack.services.audio.handlers.AudioSwitchHandler
import websockets.basics.StompWebsocketProvider
import java.io.InputStream
import javax.inject.Inject


@AndroidEntryPoint
class WebsocketService : Service(), WebsocketStompDataConnector, WebRtcDataConnector {
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
    lateinit var stompWebsocketProviderImpl: Lazy<StompWebsocketProviderImpl>

    @Inject
    lateinit var genreInteractor: GenreInteractor

    private val stompWebsocketProvider: StompWebsocketProvider by lazy {
        stompWebsocketProviderImpl.get()
    }

    private val stompWebRtcProvider: WebRtcSocketProvider by lazy {
        stompWebsocketProviderImpl.get()
    }


    private val audioHandler: AudioHandler = AudioSwitchHandler(this@WebsocketService)
    private val streamPeerConnectionFactory = StreamPeerConnectionFactory(this@WebsocketService)

    override val sessionManager: WebRtcSessionManager by lazy {
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

    override fun sendMessageInChat(roomId: Long, message: WebsocketMessageSendEntity) {
        stompWebsocketProvider.sendMessageInChat(roomId, message)
    }

    override fun connectToChatToListening(roomId: Long) {
        stompWebsocketProvider.subscribeOnChat(roomId)
    }

    override fun disconnectFromChat() {
        stompWebsocketProvider.disconnectFromChat()
    }

    override fun acceptOffer(roomId: Long) {
        stompWebsocketProvider.acceptOffer(
            roomId = roomId
        )
    }

    override fun declineOffer(roomId: Long) {
        stompWebsocketProvider.declineOffer(
            roomId = roomId,
        )
    }

    override fun subscribeOnTracks(roomId: Long) {
        stompWebsocketProvider.listenToTracks(roomId)

        serviceScope.launch {
            stompWebsocketProvider.trackFlow.collectLatest {
                when (val result = genreInteractor.getTrackById(it)) {
                    is Entity.Success -> {
                        initializeExoPlayer(result.data.trackUrl)
                    }

                    is Entity.Error -> {

                    }

                }
            }
        }
    }

    override fun addTrackToQueue(roomId: Long, trackId: Long) {
        stompWebsocketProvider.addTrackToQueue(
            roomId = roomId,
            trackId = trackId
        )
    }

    override fun listenToInvites() {
        stompWebsocketProvider.listenToInvites()
    }

    ////////////////   WebRtc
    override fun connectToWebRtc(roomId: Long) {
        stompWebRtcProvider.connectWebRtc(roomId)
        serviceScope.launch {
            sessionManager.signalingClient.sessionStateFlow.collectLatest { sessionState ->
                Log.i("sessionState", sessionState.name)
            }

            sessionManager.signalingClient.signalingCommandFlow.collectLatest { signalingCommandFlow ->
                Log.i("signalingCommandFlow", signalingCommandFlow.first.name)
            }
        }

    }

    override fun disconnectWebRtc() {
    }

    //////////////////////////// EXO PLAYER

//    fun launchNewTrack(url : String){
//        serviceScope.launch {
//            when(val inputStream = roomInteractor.getHlsMusicStream(url)){
//                is Entity.Success -> {
//                    initializeExoPlayer(
//                        inputStream
//                    )
//                }
//                is Entity.Error -> {}
//            }
//        }
//    }

    @Inject
    lateinit var exoPlayer: ExoPlayer

//    private val exoPlayerListener by lazy { ExoPlayerListener() }

    private var playPauseState = true
    private var currentWindow = 0
    private var playbackPosition = 0L

    private fun initializeExoPlayer(m3u8Url: String) {
        serviceScope.launch {
            withContext(Dispatchers.Main) {
                exoPlayer.also {
                    val mediaSource = buildMediaSource(m3u8Url)
                    it.setMediaSource(mediaSource)
                    it.playWhenReady = playPauseState
                    it.seekTo(currentWindow, playbackPosition)
                    it.prepare()
                }
            }
        }


    }

    private fun buildMediaSource(url: String): MediaSource {

        val dataSourceFactory = DefaultHttpDataSource.Factory()
        return HlsMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(Uri.parse(url)))
    }


//    inner class ExoPlayerListener : Player.Listener {
//        override fun onTimelineChanged(timeline: Timeline, reason: Int) {

//            exoPlayer.let {
//                val manifest = it.currentManifest
//                manifest?.let {
//                    val hlsManifest = it as HlsManifest
//                }
//            }
//        }
//    }


}