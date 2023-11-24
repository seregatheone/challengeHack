package challengeHack.dto.auth.request

import com.google.gson.annotations.SerializedName

data class RefreshTokenDto(
    @SerializedName("refresh") val refreshToken: String
)