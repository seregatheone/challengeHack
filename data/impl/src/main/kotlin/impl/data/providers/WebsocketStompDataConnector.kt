package impl.data.providers

import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import kotlinx.coroutines.flow.Flow


interface WebsocketStompDataConnector {
    var messageFlow : Flow<WebsocketMessageReceivedEntity>
    fun initStompWebsocket()
    fun reconnectStompWebsocket()
    fun disconnectStompWebsocket()
    fun sendMessageInChat(chatId : Int, message : WebsocketMessageSendEntity)
    fun connectToChatToListening(chatId : Int)
    fun disconnectFromChat()

}