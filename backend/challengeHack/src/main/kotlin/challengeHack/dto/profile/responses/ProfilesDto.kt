package challengeHack.dto.profile.responses

import challengeHack.dto.rooms.response.UserProfileDto
import com.google.gson.annotations.SerializedName

data class ProfilesDto (
    @SerializedName("profiles")
    val profiles: List<UserProfileDto>
)