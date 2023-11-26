package impl.data.providers

import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import kotlinx.coroutines.flow.Flow


interface WebsocketStompDataConnector {
    var messageFlow : Flow<WebsocketMessageReceivedEntity>
    fun initStompWebsocket()
    fun reconnectStompWebsocket()
    fun disconnectStompWebsocket()
    fun sendMessageInChat(roomId : Long, message : WebsocketMessageSendEntity)
    fun connectToChatToListening(roomId : Long)
    fun disconnectFromChat()

////
    fun listenToInvites()
    fun acceptOffer(roomId : Long)
    fun declineOffer(roomId : Long)
    /////

    fun subscribeOnTracks(roomId : Long)

    fun addTrackToQueue(roomId : Long, trackId : Long)

}