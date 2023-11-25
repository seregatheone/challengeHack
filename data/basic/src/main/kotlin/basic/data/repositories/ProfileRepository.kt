package basic.data.repositories

import basic.domain.profile.models.MyProfileDataEntity
import common.domain.entity.Entity

interface ProfileRepository {
    suspend fun getMineProfile() : Entity<MyProfileDataEntity>
}