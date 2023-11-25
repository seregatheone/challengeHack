package pat.project.challengehack.di

import basic.data.repositories.AuthRepository
import basic.data.repositories.TrackRepository
import basic.data.repositories.ProfileRepository
import basic.data.repositories.RoomRepository
import basic.domain.auth.interactors.AuthInteractor
import basic.domain.genre.interactors.GenreInteractor
import basic.domain.main.interactors.MainIntercator
import basic.domain.profile.interactors.ProfileInteractor
import basic.domain.room.interactors.RoomInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.domain.interactors.AuthInteractorImpl
import impl.domain.interactors.GenreInteractorImpl
import impl.domain.interactors.MainInteractorImpl
import impl.domain.interactors.ProfileInteractorImpl
import impl.domain.interactors.RoomInteractorImpl


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
    fun provideRoomsInteractor(
        roomRepository: RoomRepository
    ): RoomInteractor {
        return RoomInteractorImpl(
            roomRepository = roomRepository
        )
    }

    @Provides
    fun provideProfileInteractor(
        profileRepository: ProfileRepository
    ): ProfileInteractor {
        return ProfileInteractorImpl(
            profileRepository = profileRepository
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