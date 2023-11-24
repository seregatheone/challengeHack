package pat.project.challengehack.di

import backend.utils.manager.TokenManager
import challengeHack.api.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.data.managers.TokenManagerImpl
import impl.data.providers.NetworkProvider
import impl.data.store.AuthorizationStore
import pat.project.challengehack.BuildConfig
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BackendChallengeHack

@Module
@InstallIn(SingletonComponent::class)
class ApiNetworkModule {

    @Provides
    @BackendChallengeHack
    fun provideUrlBackendChallengeHack(): String = BuildConfig.CHALLENGE_HACK_BACKEND

    @Provides
    fun provideTokenManager(
        store: AuthorizationStore,
        @BackendChallengeHack host: String,
    ): TokenManager = TokenManagerImpl(
        store,
        host,
    )

    @Provides
    fun provideNetworkProvider(
        @BackendChallengeHack host: String,
        manager: TokenManager,
    ): NetworkProvider = NetworkProvider(
        host,
        manager,
    )

    @Provides
    fun provideAuthApi(
        provider: NetworkProvider,
    ): AuthApi = provider.provideRetrofit(AuthApi::class.java)
}
