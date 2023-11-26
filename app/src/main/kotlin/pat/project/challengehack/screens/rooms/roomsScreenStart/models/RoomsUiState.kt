package pat.project.challengehack.screens.rooms.roomsScreenStart.models

import basic.domain.room.models.RoomsInvitationEntity

data class RoomsUiState (
    val invitationList : List<RoomsInvitationEntity> = emptyList(),

)