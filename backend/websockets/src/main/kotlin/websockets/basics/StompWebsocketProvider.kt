package websockets.basics

import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import kotlinx.coroutines.flow.SharedFlow

interface StompWebsocketProvider {
    val messageFlow: SharedFlow<WebsocketMessageReceivedEntity>
    fun connect()
    fun reconnect()
    fun subscribeOnChat(chatId : Int)
    fun disconnectFromChat()
    fun sendMessage(chatId : Int, message: WebsocketMessageSendEntity)
    fun disconnect()
}