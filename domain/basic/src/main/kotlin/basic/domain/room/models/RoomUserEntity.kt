package basic.domain.room.models


data class RoomParticipantBaseEntity(
    val userId: Long,
    val ownerId : Long,
    val isOwner : Boolean
)