package impl.data.repositories

import backend.utils.models.ResponseStatus
import basic.data.repositories.ProfileRepository
import basic.domain.profile.models.MyProfileDataEntity
import challengeHack.api.ProfileApi
import common.domain.entity.Entity
import impl.data.base.BaseRepository
import impl.data.mappers.asEntity

class ProfileRepositoryImpl(
    private val profileApi: ProfileApi
) : BaseRepository(TAG), ProfileRepository {
    override suspend fun getMineProfile(): Entity<MyProfileDataEntity> {
        return when (val response = safeApiSuspendResult {
            profileApi.getProfileInfo()
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

    companion object {
        val TAG = ProfileRepositoryImpl::class.toString()
    }
}