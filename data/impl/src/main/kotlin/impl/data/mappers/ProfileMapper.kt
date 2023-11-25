package impl.data.mappers

import basic.domain.profile.models.MyProfileDataEntity
import challengeHack.dto.profile.responses.ProfileInfoDto


fun ProfileInfoDto.asEntity(): MyProfileDataEntity {
    return MyProfileDataEntity(
        userId = userId,
        username = username,
        profilePictureUrl = profilePictureUrl,
        email = email,
    )
}