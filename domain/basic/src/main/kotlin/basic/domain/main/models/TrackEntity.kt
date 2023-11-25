package basic.domain.main.models

data class TrackEntity (
    val trackId : Int,
    val name : String,
    val bandName : String,
    val albumId: Int,
    val trackUrl : String,
    val pictureUrl : String,
    val clipUrl : String,
    val duration : Int,
    val published : String,
)