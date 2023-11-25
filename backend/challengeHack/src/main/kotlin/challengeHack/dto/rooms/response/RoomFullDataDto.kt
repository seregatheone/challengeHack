package challengeHack.dto.rooms.response

import com.google.gson.annotations.SerializedName

data class RoomFullDataDto(
    @SerializedName("ownerId")
    val ownerId : Long,
    @SerializedName("tracks")
    val tracks : List<TrackResponseDto>,
    @SerializedName("messages")
    val messages: List<ChatMessageDto>,
    @SerializedName("users")
    val users : List<Long>,
    @SerializedName("owner")
    val owner : Boolean

)