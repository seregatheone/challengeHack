package basic.domain.main.models

data class AlbumEntity(
    val albumId: Int,
    val name : String,
    val pictureUrl : String,
    val bandId : Int,
    val bandName : String,
    val published : Long,
)
