package impl.data.repositories

import backend.utils.models.ResponseStatus
import basic.data.repositories.RoomRepository
import basic.domain.room.models.ProfilesEntity
import basic.domain.room.models.RoomAllInfoEntity
import basic.domain.room.models.RoomsInvitationEntity
import basic.domain.room.models.UserProfileEntity
import challengeHack.api.RoomApi
import challengeHack.dto.profile.request.ProfileIdsDto
import common.domain.entity.Entity
import impl.data.base.BaseRepository
import impl.data.mappers.asEntity
import java.io.InputStream

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

    override suspend fun getUsersById(ids: List<Long>): Entity<ProfilesEntity> {
        return when (val response = safeApiSuspendResult {
            roomApi.getUsersById(ProfileIdsDto(ids))
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

    override suspend fun joinInRoom(roomId: Long, artifact: String): Entity<RoomAllInfoEntity> {
        return when (val response = safeApiSuspendResult {
            roomApi.joinInRoom(roomId, artifact)
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

    override suspend fun getHlsMusicStream(m3u8Url: String): Entity<InputStream> {
        return when (val response = safeApiSuspendResult {
            roomApi.getHlsMusicStream(m3u8Url)
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.byteStream()
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


    companion object{
        val TAG = RoomRepositoryImpl::class.toString()
    }
}