package websockets.dto.request

import com.google.gson.annotations.SerializedName

data class WebsocketMessageSendDto (
    @SerializedName("content")
    val content : String,
    @SerializedName("sendTimestamp")
    val sendTimestamp : Long,
    @SerializedName("replyId")
    val replyId :Int?,
    @SerializedName("fileIds")
    val fileIds : List<Int>?
)