package basic.domain.room.models

data class TrackResponseEntity (
    val trackId : Long,
    val trackName : String,
    val bandName : String,
    val albumId : Long,
    val trackUrl : String,
    val pictureUrl : String,
    val clipUrl : String,
    val duration: Long,
    val genre : String,
)