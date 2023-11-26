package impl.data.mappers

import basic.domain.room.models.ChatMessageEntity
import basic.domain.room.models.ProfilesEntity
import basic.domain.room.models.RoomAllInfoEntity
import basic.domain.room.models.TrackResponseEntity
import basic.domain.room.models.UserProfileEntity
import challengeHack.dto.profile.responses.ProfilesDto
import challengeHack.dto.rooms.response.ChatMessageDto
import challengeHack.dto.rooms.response.RoomFullDataDto
import challengeHack.dto.rooms.response.TrackResponseDto
import challengeHack.dto.rooms.response.UserProfileDto


fun RoomFullDataDto.asEntity(): RoomAllInfoEntity {
    return RoomAllInfoEntity(
        ownerId = ownerId,
        tracks = tracks.map { it.asEntity() },
        messages = messages.map { it.asEntity() },
        users = users,
        isOwner = owner,
        offers = offers,
        artifact = artifact
    )
}

fun TrackResponseDto.asEntity(): TrackResponseEntity {
    return TrackResponseEntity(
        trackId = trackId,
        trackName = name,
        bandName = bandName,
        albumId = albumId,
        trackUrl = trackUrl,
        pictureUrl = pictureUrl,
        clipUrl = clipUrl,
        duration = duration,
        genre = genre,
    )
}

fun ChatMessageDto.asEntity(): ChatMessageEntity {
    return ChatMessageEntity(
        sendTimestamp = sendTimestamp,
        content = content,
        senderPictureUrl = senderPictureUrl,
        senderId = senderId,
    )
}

fun ProfilesDto.asEntity(): ProfilesEntity {
    return ProfilesEntity(
        profiles = profiles.map { it.asEntity() }
    )
}

fun UserProfileDto.asEntity(): UserProfileEntity {
    return UserProfileEntity(
        userId = userId,
        username = username,
        profilePictureUrl = profilePictureUrl,
    )
}