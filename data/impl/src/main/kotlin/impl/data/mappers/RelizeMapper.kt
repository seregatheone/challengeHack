package impl.data.mappers

import basic.domain.auth.models.registration.GenderEntityRegistration
import basic.domain.auth.models.registration.RegistrationEntity
import basic.domain.main.models.RelizeEntity
import challengeHack.dto.auth.request.GenderDto
import challengeHack.dto.auth.request.RegistrationDto
import challengeHack.dto.auth.response.RelizeDtoResponse

fun RelizeDtoResponse.asEntity(): RelizeEntity {
    return RelizeEntity(
        albumId = albumId,
        name = name,
        pictureUrl = pictureUrl,
        bandName = bandName,
        bandId = bandId,
        published = published,
    )
}

