package challengeHack.dto.auth.response

import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("pictureUrl")
    val pictureUrl : String,
    @SerializedName("genre")
    val genre : String,
)
