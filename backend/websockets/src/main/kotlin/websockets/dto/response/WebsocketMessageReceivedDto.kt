package websockets.dto.response

import com.google.gson.annotations.SerializedName

data class WebsocketMessageReceivedDto(
    @SerializedName("sendTimestamp")
    val sendTimestamp: Long,
    @SerializedName("content")
    val content: String,
    @SerializedName("senderId")
    val senderId: Long,
    @SerializedName("senderPictureUrl")
    val senderPictureUrl:String,
)
