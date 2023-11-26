package challengeHack.dto.profile.request

import com.google.gson.annotations.SerializedName

data class ProfileIdsDto (
    @SerializedName("ids")
    val ids: List<Long>
)