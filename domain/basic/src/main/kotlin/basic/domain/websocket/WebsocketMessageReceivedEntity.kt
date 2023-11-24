package basic.domain.websocket

data class WebsocketMessageReceivedEntity(
    val text: String,
    val sendTime: String,
    val senderId : Long
)
