package pat.project.challengehack.screens.rooms.roomScreen.models

import basic.domain.main.models.GenreEntity
import basic.domain.main.models.TrackEntity
import basic.domain.room.models.ParticipantInfoEntity
import basic.domain.room.models.RoomAllInfoEntity
import basic.domain.room.models.UserProfileEntity

data class RoomUiState(
    val roomDataEntity: RoomAllInfoEntity? = null,
    val roomParticipantsFullDataEntity: List<UserProfileEntity> = emptyList(),
    val myId: Long? = null,
    val soundList: List<TrackEntity> = emptyList(),
    )