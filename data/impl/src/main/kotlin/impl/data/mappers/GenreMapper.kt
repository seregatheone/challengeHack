package impl.data.mappers

import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import challengeHack.dto.auth.response.GenreDto
import challengeHack.dto.auth.response.RelizeDtoResponse

fun GenreDto.asEntity(): GenreEntity {
    return GenreEntity(
        genre = genre,
        pictureUrl = pictureUrl
    )
}