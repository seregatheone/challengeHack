package pat.project.challengehack.screens.rooms.roomScreen.models

import basic.domain.room.models.ParticipantInfoEntity
import basic.domain.room.models.RoomAllInfoEntity

data class RoomUiState (
    val roomDataEntity : RoomAllInfoEntity? = null,
    val roomParticipantsFullDataEntity: List<ParticipantInfoEntity> = emptyList(),
    val myId : Long? = null,
    val textQr: String = "zalupa",

)