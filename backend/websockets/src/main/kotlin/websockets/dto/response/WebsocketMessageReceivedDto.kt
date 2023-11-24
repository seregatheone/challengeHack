package websockets.dto.response

import com.google.gson.annotations.SerializedName

data class WebsocketMessageReceivedDto(
    @SerializedName("messageId")
    val messageId: Long,
    @SerializedName("sendTimestamp")
    val sendTimestamp: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("chatId")
    val chatId: Long,
    @SerializedName("senderId")
    val senderId: Long,
    @SerializedName("replyId")
    val replyId: Long?,
    @SerializedName("replyContent")
    val replyContent: String?,
    @SerializedName("fileUrls")
    val fileUrls: List<String>?,
)
