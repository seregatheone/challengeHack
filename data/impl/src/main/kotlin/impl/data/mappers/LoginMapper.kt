package impl.data.mappers

import basic.domain.auth.models.login.LoginEntity
import challengeHack.dto.auth.request.LoginDto
fun LoginEntity.asDto(): LoginDto {
    return LoginDto(
        username = username,
        password = password,
    )
}