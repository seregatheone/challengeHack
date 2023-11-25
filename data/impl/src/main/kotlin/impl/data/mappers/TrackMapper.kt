package impl.data.mappers

import basic.domain.main.models.TrackEntity
import challengeHack.dto.auth.response.TrackDto

fun TrackDto.asEntity(): TrackEntity {
    return TrackEntity(
        trackId = trackId,
        name = name,
        bandName = bandName,
        albumId = albumId,
        trackUrl = trackUrl,
        pictureUrl = pictureUrl,
        clipUrl = clipUrl,
        duration = duration,
    )
}