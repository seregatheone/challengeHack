package challengeHack.dto.rooms.response

import com.google.gson.annotations.SerializedName

data class UserProfileDto(
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("username")
    val username: String,
    @SerializedName("profilePictureUrl")
    val profilePictureUrl: String,
)
