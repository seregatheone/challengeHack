package pat.project.challengehack.di

import basic.data.repositories.AuthRepository
import basic.data.repositories.TrackRepository
import basic.domain.auth.interactors.AuthInteractor
import basic.domain.genre.interactors.GenreInteractor
import basic.domain.main.interactors.MainIntercator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.domain.interactors.AuthInteractorImpl
import impl.domain.interactors.GenreInteractorImpl
import impl.domain.interactors.MainInteractorImpl


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

    @Provides
    fun provideMainInteractor(
        trackRepository: TrackRepository
    ): MainIntercator {
        return MainInteractorImpl(
            mainRepository = trackRepository
        )
    }

    @Provides
    fun provideGenreInteractor(
        trackRepository: TrackRepository
    ): GenreInteractor {
        return GenreInteractorImpl(
             trackRepository = trackRepository
        )
    }
}