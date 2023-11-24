package challengeHack.dto.auth.request

import challengeHack.dto.auth.request.GenderDto
import com.google.gson.annotations.SerializedName

data class RegistrationDto(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: GenderDto,
)