package impl.data.stomp

import android.util.Log
import basic.domain.webrtc.SignalingCommand
import basic.domain.webrtc.WebRTCSessionState
import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import basics.WebRtcClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import impl.data.mappers.websockets.toEntity
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ua.naiksoftware.stomp.StompClient
import ua.naiksoftware.stomp.dto.LifecycleEvent
import ua.naiksoftware.stomp.dto.StompMessage
import websockets.basics.StompClientConfig
import websockets.basics.WebSocketState
import websockets.basics.StompWebsocketProvider
import basics.WebRtcSocketProvider
import kotlinx.coroutines.cancel
import websockets.basics.RoomStompClientConfig
import websockets.dto.response.WebsocketMessageReceivedDto

class StompWebsocketProviderImpl(
    private val stompClient: StompClient,
    private val compositeDisposable: CompositeDisposable,
) : StompWebsocketProvider, WebRtcSocketProvider {
    private val _messageFlow = MutableSharedFlow<WebsocketMessageReceivedEntity>(
        replay = 2,
        extraBufferCapacity = 3,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    override val messageFlow: SharedFlow<WebsocketMessageReceivedEntity> = _messageFlow

    private val _invitesFlow = MutableSharedFlow<Long>(
        replay = 2,
        extraBufferCapacity = 3,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    override val invitesFlow: SharedFlow<Long> = _invitesFlow

    private val _trackFlow = MutableSharedFlow<Long>(
        replay = 2,
        extraBufferCapacity = 3,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    override val trackFlow: SharedFlow<Long> = _trackFlow

    private val _newUserAdded = MutableSharedFlow<Long>(
        replay = 2,
        extraBufferCapacity = 3,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    override val newUserAdded: SharedFlow<Long> = _newUserAdded

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val signalingScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private var websocketState: WebSocketState = WebSocketState.Init

    private val gson: Gson = GsonBuilder()
        .create()

    private var isStompWorking = false

    private var chatTopic = ""

    override fun connect() {
        Log.i(TAG, "socket connected")
        stompClient.connect()
        isStompWorking = true
        websocketState = WebSocketState.Connected
    }

    override fun reconnect() {
        if (!stompClient.isConnected) {
            stompClient.connect()
            websocketState = WebSocketState.Connected
        }

    }

    override fun subscribeOnChat(roomId: Long) {
        chatTopic = StompClientConfig.getChatListeningUrl(roomId)
        val topicSubscribe = stompClient.topic(StompClientConfig.getChatListeningUrl(roomId))
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ topicMessage: StompMessage ->
                Log.i(TAG, topicMessage.payload)
                val message: WebsocketMessageReceivedDto =
                    gson.fromJson(topicMessage.payload, WebsocketMessageReceivedDto::class.java)

                coroutineScope.launch {
                    _messageFlow.emit(message.toEntity())
                }
            },
                {
                    Log.e(TAG, "Error!", it) //обработка ошибок
                }
            )

        //подписываемся на состояние WebSocket'a
        val lifecycleSubscribe = stompClient.lifecycle()
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { lifecycleEvent: LifecycleEvent ->
                when (lifecycleEvent.type!!) {
                    LifecycleEvent.Type.OPENED -> Log.d(TAG, "Stomp connection opened")
                    LifecycleEvent.Type.ERROR -> Log.e(TAG, "Error", lifecycleEvent.exception)
                    LifecycleEvent.Type.FAILED_SERVER_HEARTBEAT,
                    LifecycleEvent.Type.CLOSED -> {
                        Log.d(TAG, "Stomp connection closed")
                    }
                }
            }

        compositeDisposable.add(lifecycleSubscribe)
        compositeDisposable.add(topicSubscribe)
    }

    override fun disconnectFromChat() {
        val topicId = stompClient.getTopicId(chatTopic)

    }

    override fun sendMessageInChat(roomId: Long, message: WebsocketMessageSendEntity) {
        val chatSocketMessage = message.toEntity()

        sendCompletable(
            stompClient.send(
                StompClientConfig.getChatSendingUrl(roomId),
                chatSocketMessage.content
            )
        )
    }

    private fun sendCompletable(request: Completable) {
        compositeDisposable.add(
            request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Log.i("requestrequest", request.toString())
                        Log.d(TAG, "Stomp sended")
//                        coroutineScope.launch {
//                            _messageFlow.emit(WebSocketState.)
//                        }
                    },
                    {
                        Log.e(TAG, "Stomp error", it)
                    }
                )
        )


    }

    override fun disconnect() {
        if (stompClient.isConnected) {
            stompClient.disconnect()
        }
    }

    override fun acceptOffer(roomId: Long) {
        sendCompletable(
            stompClient.send(
                RoomStompClientConfig.getRoomAcceptUrl(roomId),
                ""
            )
        )
    }

    override fun declineOffer(roomId: Long) {
        sendCompletable(
            stompClient.send(
                RoomStompClientConfig.getRoomDeclineUrl(roomId),
                ""
            )
        )
    }

    override fun addTrackToQueue(roomId: Long, trackId: Long) {
        sendCompletable(
            stompClient.send(
                RoomStompClientConfig.getAddToQueueTrack(roomId),
                trackId.toString()
            )
        )
    }

    override fun newUserAddedListener(roomId: Long) {
        val topicSubscribe =
            stompClient.topic(RoomStompClientConfig.getNewUsersListeningUrl(roomId))
                .subscribeOn(Schedulers.io(), false)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ topicMessage: StompMessage ->
                    Log.i(TAG, topicMessage.payload)
                    try {
                        val userId = topicMessage.payload.split(':')[1].toLong()

                        coroutineScope.launch {
                            _newUserAdded.emit(
                                userId
                            )
                        }
                    } catch (e: Exception) {
                        Log.e("error", e.message.toString())
                    }
                },
                    {
                        Log.e(TAG, "Error!", it) //обработка ошибок
                    }
                )
        val lifecycleSubscribe = stompClient.lifecycle()
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { lifecycleEvent: LifecycleEvent ->
                when (lifecycleEvent.type!!) {
                    LifecycleEvent.Type.OPENED -> Log.d(TAG, "Stomp connection opened")
                    LifecycleEvent.Type.ERROR -> Log.e(TAG, "Error", lifecycleEvent.exception)
                    LifecycleEvent.Type.FAILED_SERVER_HEARTBEAT,
                    LifecycleEvent.Type.CLOSED -> {
                        Log.d(TAG, "Stomp connection closed")
                    }
                }
            }

        compositeDisposable.add(lifecycleSubscribe)
        compositeDisposable.add(topicSubscribe)
    }

    override fun listenToInvites() {
        val topicSubscribe = stompClient.topic(RoomStompClientConfig.getListeningInvitesUrl())
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ topicMessage: StompMessage ->
                Log.i(TAG, topicMessage.payload)
                try {
                    val inviteId = topicMessage.payload.split(':')[1].toLong()

                    coroutineScope.launch {
                        _invitesFlow.emit(inviteId)
                    }
                } catch (e: Exception) {
                    Log.e("error", e.message.toString())
                }
            },
                {
                    Log.e(TAG, "Error!", it) //обработка ошибок
                }
            )

        //подписываемся на состояние WebSocket'a
        val lifecycleSubscribe = stompClient.lifecycle()
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { lifecycleEvent: LifecycleEvent ->
                when (lifecycleEvent.type!!) {
                    LifecycleEvent.Type.OPENED -> Log.d(TAG, "Stomp connection opened")
                    LifecycleEvent.Type.ERROR -> Log.e(TAG, "Error", lifecycleEvent.exception)
                    LifecycleEvent.Type.FAILED_SERVER_HEARTBEAT,
                    LifecycleEvent.Type.CLOSED -> {
                        Log.d(TAG, "Stomp connection closed")
                    }
                }
            }

        compositeDisposable.add(lifecycleSubscribe)
        compositeDisposable.add(topicSubscribe)
    }

    override fun listenToTracks(roomId: Long) {
        val topicSubscribe = stompClient.topic(RoomStompClientConfig.getTrackListeningUrl(roomId))
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ topicMessage: StompMessage ->
                Log.i(TAG, topicMessage.payload)

                try {
                    val content = topicMessage.payload
                    val trackId = topicMessage.payload.split(':')[1].toLong()

                    coroutineScope.launch {
                        _trackFlow.emit(trackId)
                    }
                } catch (e: Exception) {
                    Log.e("error", e.message.toString())
                }

            },
                {
                    Log.e(TAG, "Error!", it) //обработка ошибок
                }
            )

        //подписываемся на состояние WebSocket'a
        val lifecycleSubscribe = stompClient.lifecycle()
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { lifecycleEvent: LifecycleEvent ->
                when (lifecycleEvent.type!!) {
                    LifecycleEvent.Type.OPENED -> Log.d(TAG, "Stomp connection opened")
                    LifecycleEvent.Type.ERROR -> Log.e(TAG, "Error", lifecycleEvent.exception)
                    LifecycleEvent.Type.FAILED_SERVER_HEARTBEAT,
                    LifecycleEvent.Type.CLOSED -> {
                        Log.d(TAG, "Stomp connection closed")
                    }
                }
            }

        compositeDisposable.add(lifecycleSubscribe)
        compositeDisposable.add(topicSubscribe)
    }


    ////////////////   WebRtc

    private var connectedRooms = mutableListOf<Long>()

    private val _sessionStateFlow = MutableStateFlow(WebRTCSessionState.Offline)
    override val sessionStateFlow = _sessionStateFlow.asStateFlow()

    private val _signalingCommandFlow = MutableSharedFlow<Pair<SignalingCommand, String>>()
    override val signalingCommandFlow = _signalingCommandFlow.asSharedFlow()
    override fun connectWebRtc(roomId: Long) {
//        if(connectedRooms.size > 1)){
//            disconnectWebRtc()
//        }
        connectedRooms.add(roomId)
        val topicSubscribe = stompClient.topic(WebRtcClient.getWebRtcSubscription(roomId))
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ topicMessage: StompMessage ->
                Log.i(TAG, topicMessage.payload)
                onMessage(topicMessage.payload)
            },
                {
                    Log.e(TAG, "Error!", it) //обработка ошибок
                }
            )

        //подписываемся на состояние WebSocket'a
        val lifecycleSubscribe = stompClient.lifecycle()
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { lifecycleEvent: LifecycleEvent ->
                when (lifecycleEvent.type!!) {
                    LifecycleEvent.Type.OPENED -> Log.d(TAG, "Stomp connection opened")
                    LifecycleEvent.Type.ERROR -> Log.e(TAG, "Error", lifecycleEvent.exception)
                    LifecycleEvent.Type.FAILED_SERVER_HEARTBEAT,
                    LifecycleEvent.Type.CLOSED -> {
                        Log.d(TAG, "Stomp connection closed")
                    }
                }
            }

        compositeDisposable.add(lifecycleSubscribe)
        compositeDisposable.add(topicSubscribe)
    }

    private fun onMessage(text: String) {
        when {
            text.startsWith(SignalingCommand.STATE.toString(), true) ->
                handleStateMessage(text)

            text.startsWith(SignalingCommand.OFFER.toString(), true) ->
                handleSignalingCommand(SignalingCommand.OFFER, text)

            text.startsWith(SignalingCommand.ANSWER.toString(), true) ->
                handleSignalingCommand(SignalingCommand.ANSWER, text)

            text.startsWith(SignalingCommand.ICE.toString(), true) ->
                handleSignalingCommand(SignalingCommand.ICE, text)
        }
    }

    private fun handleStateMessage(message: String) {
        val state = getSeparatedMessage(message)
        _sessionStateFlow.value = WebRTCSessionState.valueOf(state)
    }

    private fun handleSignalingCommand(command: SignalingCommand, text: String) {
        val value = getSeparatedMessage(text)
        signalingScope.launch {
            _signalingCommandFlow.emit(command to value)
        }
    }

    private fun getSeparatedMessage(text: String) = text.substringAfter(' ')

    override fun sendCommand(signalingCommand: SignalingCommand, message: String) {
        if (connectedRooms.isNotEmpty()) {
            sendCompletable(
                stompClient.send(
                    WebRtcClient.getWebRtcSendingUrl(connectedRooms.first()),
                    "$signalingCommand $message"
                )
            )
        }

    }

    override fun disconnectWebRtc() {
        connectedRooms.clear()
        _sessionStateFlow.value = WebRTCSessionState.Offline
        signalingScope.cancel()
    }

    override fun dispose() {
        connectedRooms.clear()
        _sessionStateFlow.value = WebRTCSessionState.Offline
        signalingScope.cancel()
    }


    companion object {
        val TAG = StompWebsocketProviderImpl::class.toString()
    }
}