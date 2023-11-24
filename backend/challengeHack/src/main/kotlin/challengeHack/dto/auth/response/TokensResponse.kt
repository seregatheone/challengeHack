package backend.conversay.dto.auth.response

import com.google.gson.annotations.SerializedName

data class TokensResponse(
    @SerializedName("access") val accessToken : String,
    @SerializedName("refresh") val refreshToken : String
)