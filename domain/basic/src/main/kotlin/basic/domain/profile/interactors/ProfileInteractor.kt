package basic.domain.profile.interactors

import basic.domain.profile.models.MyProfileDataEntity
import common.domain.entity.Entity

interface ProfileInteractor {
    suspend fun getMineProfile() : Entity<MyProfileDataEntity>
}