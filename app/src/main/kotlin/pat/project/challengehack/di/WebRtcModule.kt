package pat.project.challengehack.di

import basics.WebRtcSocketProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.data.stomp.StompWebsocketProviderImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WebRtcModule {

    @Provides
    @Singleton
    fun provideWebRtcSocketProvider(
        stompWebsocketProviderImpl : StompWebsocketProviderImpl
    ): WebRtcSocketProvider {
        return stompWebsocketProviderImpl
    }
}