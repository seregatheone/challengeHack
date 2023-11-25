package challengeHack.dto.rooms.response

import com.google.gson.annotations.SerializedName

data class ChatMessageDto (
    @SerializedName("senderId")
    val senderId: Long,
    @SerializedName("senderPictureUrl")
    val senderPictureUrl: String,
    @SerializedName("content")
    val content : String,
    @SerializedName("sendTimestamp")
    val sendTimestamp: Long
)