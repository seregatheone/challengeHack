package challengeHack.dto.auth.response

import com.google.gson.annotations.SerializedName

data class TrackDto (
    @SerializedName("trackId")
    val trackId : Long,
    @SerializedName("name")
    val name : String,
    @SerializedName("bandName")
    val bandName : String,
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("trackUrl")
    val trackUrl : String,
    @SerializedName("pictureUrl")
    val pictureUrl : String,
    @SerializedName("clipUrl")
    val clipUrl : String,
    @SerializedName("duration")
    val duration : Int,
    @SerializedName("genre")
    val genre : String,
)