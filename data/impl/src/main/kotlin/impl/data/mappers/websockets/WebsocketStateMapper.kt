package impl.data.mappers.websockets

import basic.domain.websocket.WebsocketMessageReceivedEntity
import websockets.basics.WebSocketState


fun WebSocketState.Message.asMessageEntity() : WebsocketMessageReceivedEntity {
    return WebsocketMessageReceivedEntity(
        text = this.text,
        sendTime = this.sendTime,
        senderId = this.senderId
    )
}