package basic.domain.room.models

data class ChatMessageEntity (
    val sendTimestamp: Long,
    val content:String,
    val senderPictureUrl: String,
    val senderId: Long,
)