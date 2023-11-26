package basic.data.repositories

import basic.domain.room.models.ProfilesEntity
import basic.domain.room.models.RoomAllInfoEntity
import basic.domain.room.models.RoomsInvitationEntity
import basic.domain.room.models.UserProfileEntity
import common.domain.entity.Entity

interface RoomRepository {
    suspend fun createRoom(): Entity<RoomAllInfoEntity>
    suspend fun getUsersById(ids: List<Long>): Entity<ProfilesEntity>
    suspend fun joinInRoom(roomId: Long, artifact: String): Entity<RoomAllInfoEntity>
    suspend fun getAllInvites() : Entity<List<RoomsInvitationEntity>>
    suspend fun getRoomAllInfoByRoomId(roomId: Long): Entity<RoomAllInfoEntity>
}