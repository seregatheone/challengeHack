package basic.domain.websocket

data class WebsocketMessageReceivedEntity(
    val text: String,
    val sendTime: Long,
    val senderUrl : String,
    val senderId : Long
)
