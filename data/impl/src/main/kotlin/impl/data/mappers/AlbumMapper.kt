package impl.data.mappers

import basic.domain.main.models.AlbumEntity
import basic.domain.main.models.GenreEntity
import challengeHack.dto.auth.response.AlbumDto
import challengeHack.dto.auth.response.GenreDto

fun AlbumDto.asEntity(): AlbumEntity {
    return AlbumEntity(
        albumId = albumId,
        name = name,
        pictureUrl = pictureUrl,
        bandId = bandId,
        bandName = bandName,
        published = published,
    )
}