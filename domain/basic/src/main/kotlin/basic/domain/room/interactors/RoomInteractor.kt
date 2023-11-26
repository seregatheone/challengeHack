package basic.domain.room.interactors

import basic.domain.room.models.RoomAllInfoEntity
import basic.domain.room.models.RoomsInvitationEntity
import common.domain.entity.Entity

interface RoomInteractor {
    suspend fun createRoom(): Entity<RoomAllInfoEntity>
    suspend fun joinInRoom(roomId: Long, artifact: String): Entity<RoomAllInfoEntity>
    suspend fun getRoomAllInfoByRoomId(roomId : Long) : Entity<RoomAllInfoEntity>
    suspend fun getAllInvites() : Entity<List<RoomsInvitationEntity>>
}