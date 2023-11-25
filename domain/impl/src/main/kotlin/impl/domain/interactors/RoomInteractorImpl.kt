package impl.domain.interactors

import basic.data.repositories.RoomRepository
import basic.domain.room.interactors.RoomInteractor
import basic.domain.room.models.RoomAllInfoEntity
import basic.domain.room.models.RoomsInvitationEntity
import common.domain.entity.Entity

class RoomInteractorImpl(
    private val roomRepository: RoomRepository
): RoomInteractor {
    override suspend fun createRoom(): Entity<RoomAllInfoEntity> {
        return roomRepository.createRoom()
    }

    override suspend fun getRoomAllInfoByRoomId(roomId: Long): Entity<RoomAllInfoEntity> {
        return roomRepository.getRoomAllInfoByRoomId(roomId)
    }

    override suspend fun getAllInvites(): Entity<List<RoomsInvitationEntity>> {
        return roomRepository.getAllInvites()
    }

}