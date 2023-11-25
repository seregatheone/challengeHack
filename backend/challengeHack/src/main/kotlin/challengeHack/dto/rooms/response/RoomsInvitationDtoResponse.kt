package challengeHack.dto.rooms.response

import com.google.gson.annotations.SerializedName

data class RoomsInvitationDtoResponse(
    @SerializedName("invitationId")
    val invitationId : String,
    @SerializedName("userPictureUrl")
    val userPictureUrl : String,
    @SerializedName("userName")
    val userName : String,
    @SerializedName("roomData")
    val roomData : RoomFullDataDto,
)