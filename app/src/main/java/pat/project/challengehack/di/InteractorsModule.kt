package pat.project.challengehack.di

import basic.data.repositories.AuthRepository
import basic.domain.auth.interactors.AuthInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.domain.interactors.AuthInteractorImpl


@Module
@InstallIn(SingletonComponent::class)
class InteractorsModule {
    @Provides
    fun provideAuthInteractor(
        authRepository: AuthRepository
    ): AuthInteractor {
        return AuthInteractorImpl(
            authRepository = authRepository
        )
    }
}