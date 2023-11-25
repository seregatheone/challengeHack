package challengeHack.dto.profile.responses

import com.google.gson.annotations.SerializedName

data class ProfileInfoDto (
    @SerializedName("userId")
    val userId : Long,
    @SerializedName("username")
    val username : String,
    @SerializedName("profilePictureUrl")
    val profilePictureUrl : String,
    @SerializedName("email")
    val email : String,
)