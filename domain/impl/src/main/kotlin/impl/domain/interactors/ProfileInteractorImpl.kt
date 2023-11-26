package impl.domain.interactors

import basic.data.repositories.ProfileRepository
import basic.domain.profile.interactors.ProfileInteractor
import basic.domain.profile.models.MyProfileDataEntity
import common.domain.entity.Entity

class ProfileInteractorImpl(
    private val profileRepository: ProfileRepository
) : ProfileInteractor {
    override suspend fun getMineProfile(): Entity<MyProfileDataEntity> {
        return profileRepository.getMineProfile()
    }
}