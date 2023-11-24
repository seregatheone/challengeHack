package pat.project.challengehack.di

import android.content.Context
import basic.data.repositories.AuthRepository
import challengeHack.api.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.data.repositories.AuthRepositoryImpl
import impl.data.store.AuthorizationStore


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providersAuthStore(context: Context): AuthorizationStore = AuthorizationStore(context)

    @Provides
    fun provideAuthRepository(
        authApi: AuthApi,
        authorizationStore: AuthorizationStore
    ): AuthRepository {
        return AuthRepositoryImpl(
            authApi = authApi,
            authorizationStore = authorizationStore
        )
    }
}