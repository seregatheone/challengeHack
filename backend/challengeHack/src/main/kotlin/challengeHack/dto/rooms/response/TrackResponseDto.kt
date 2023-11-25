package challengeHack.dto.rooms.response

import com.google.gson.annotations.SerializedName

data class TrackResponseDto (
    @SerializedName("trackId")
    val trackId: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("bandName")
    val bandName: String,
    @SerializedName("albumId")
    val albumId: Long,
    @SerializedName("trackUrl")
    val trackUrl: String,
    @SerializedName("pictureUrl")
    val pictureUrl: String,
    @SerializedName("clipUrl")
    val clipUrl: String,
    @SerializedName("duration")
    val duration: Long,
    @SerializedName("genre")
    val genre: String
)