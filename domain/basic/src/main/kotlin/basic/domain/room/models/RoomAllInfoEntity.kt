package basic.domain.room.models

data class RoomAllInfoEntity (
    val ownerId : Long,
    val tracks : List<TrackResponseEntity>,
    val messages : List<ChatMessageEntity>,
    val users : List<Long>,
    val isOwner : Boolean
)