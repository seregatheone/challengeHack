package challengeHack.dto.auth.response

import com.google.gson.annotations.SerializedName

data class RelizeDtoResponse (
    @SerializedName("albumId")
    val albumId : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("pictureUrl")
    val pictureUrl : String,
    @SerializedName("bandId")
    val bandId : Int,
    @SerializedName("bandName")
    val bandName : String,
    @SerializedName("published")
    val published : Long,
)