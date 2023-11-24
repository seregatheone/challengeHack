package impl.data.mappers

import challengeHack.dto.auth.request.GenderDto
import challengeHack.dto.auth.request.RegistrationDto
import basic.domain.auth.models.registration.GenderEntityRegistration
import basic.domain.auth.models.registration.RegistrationEntity

fun RegistrationEntity.asDto(): RegistrationDto {
    return RegistrationDto(
        username = username,
        password = password,
        email = email,
        gender = gender.asDto(),
    )
}

fun GenderEntityRegistration.asDto() : GenderDto {
    return when(this){
        GenderEntityRegistration.FEMALE -> GenderDto.FEMALE
        GenderEntityRegistration.MALE -> GenderDto.MALE
    }
}