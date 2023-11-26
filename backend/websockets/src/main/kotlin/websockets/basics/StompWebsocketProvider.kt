package websockets.basics

import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import kotlinx.coroutines.flow.SharedFlow

interface StompWebsocketProvider {
    val messageFlow: SharedFlow<WebsocketMessageReceivedEntity>
    val invitesFlow : SharedFlow<Long>
    val trackFlow : SharedFlow<Long>
    val newUserAdded : SharedFlow<Long>
    fun connect()
    fun reconnect()
    fun subscribeOnChat(roomId : Long)
    fun disconnectFromChat()
    fun sendMessageInChat(roomId : Long, message: WebsocketMessageSendEntity)
    fun disconnect()

    fun acceptOffer(roomId : Long)
    fun declineOffer(roomId : Long)
    fun listenToInvites()

    fun listenToTracks(roomId : Long)

    fun addTrackToQueue(roomId: Long, trackId : Long)
    //////
    fun newUserAddedListener(roomId : Long)

}