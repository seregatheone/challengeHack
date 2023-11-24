package basic.domain.websocket

data class WebsocketMessageSendEntity(
    val content : String,
    val sendTimestamp  : Long,
    val replyId :Int? = null,
    val fileIds :List<Int>? = null,
)