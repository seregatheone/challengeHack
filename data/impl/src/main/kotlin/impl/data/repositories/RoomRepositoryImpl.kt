package impl.data.repositories

import backend.utils.models.ResponseStatus
import basic.data.repositories.RoomRepository
import basic.domain.room.models.RoomAllInfoEntity
import basic.domain.room.models.RoomsInvitationEntity
import challengeHack.api.RoomApi
import common.domain.entity.Entity
import impl.data.base.BaseRepository
import impl.data.mappers.asEntity

class RoomRepositoryImpl(
    private val roomApi: RoomApi
) :BaseRepository(TAG), RoomRepository {

    override suspend fun createRoom(): Entity<RoomAllInfoEntity> {
        return when (val response = safeApiSuspendResult {
            roomApi.createRoom()
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.asEntity()
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }
            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }

    override suspend fun getAllInvites(): Entity<List<RoomsInvitationEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRoomAllInfoByRoomId(roomId: Long): Entity<RoomAllInfoEntity> {
        TODO("Not yet implemented")
    }

    companion object{
        val TAG = RoomRepositoryImpl::class.toString()
    }
}