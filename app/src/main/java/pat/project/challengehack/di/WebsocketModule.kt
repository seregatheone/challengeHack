package pat.project.challengehack.di

import android.util.Log
import backend.utils.manager.TokenManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import impl.data.providers.StompHeadersManager
import impl.data.stomp.StompWebsocketProviderImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import pat.project.challengehack.BuildConfig
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.Stomp.ConnectionProvider
import ua.naiksoftware.stomp.StompClient
import ua.naiksoftware.stomp.dto.LifecycleEvent
import websockets.basics.StompClientConfig
import websockets.basics.StompWebsocketProvider
import javax.inject.Qualifier
import javax.inject.Singleton


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class WebsocketsConversay

@Module
@InstallIn(SingletonComponent::class)
class WebsocketModule {

    @Provides
    @WebsocketsConversay
    fun provideUrlWebsocketsConversay(): String = BuildConfig.CHALLENGE_HACK_WEBSOCKETS

    @Provides
    @Singleton
    fun provideConnectionProvider(): ConnectionProvider = ConnectionProvider.OKHTTP

    @Provides
    fun provideStompHeaders(
        tokenManager: TokenManager
    ): StompHeadersManager {
        return StompHeadersManager(tokenManager)
    }

    @Provides
    @Singleton
    fun provideDisposable(
        stompClient: StompClient
    ): Disposable {
        return stompClient.lifecycle()
            .subscribeOn(Schedulers.io(), false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { lifecycleEvent: LifecycleEvent ->
                when (lifecycleEvent.type!!) {
                    LifecycleEvent.Type.OPENED -> Log.d(
                        "WebsocketStatus",
                        "Stomp connection opened"
                    )

                    LifecycleEvent.Type.ERROR -> Log.e(
                        "WebsocketStatus",
                        "Error",
                        lifecycleEvent.exception
                    )

                    LifecycleEvent.Type.FAILED_SERVER_HEARTBEAT -> Log.e(
                        "WebsocketStatus",
                        "Server died",
                        lifecycleEvent.exception
                    )

                    LifecycleEvent.Type.CLOSED -> {
                        Log.d("WebsocketStatus", "Stomp connection closed")
                    }
                }
            }

    }

    @Provides
    @Singleton
    fun provideCompositeDisposable():CompositeDisposable{
        return CompositeDisposable()
    }


    @Provides
    @Singleton
    fun provideStompClient(
        connectionProvider: ConnectionProvider,
        @WebsocketsConversay websocketsUrl: String,
        stompHeaders: StompHeadersManager,
    ): StompClient {
        return Stomp.over(connectionProvider, websocketsUrl, stompHeaders.getHeaders())
            .withClientHeartbeat(StompClientConfig.clientHeartbeat)
            .withServerHeartbeat(StompClientConfig.serverHeartbeat)
    }

    @Provides
    @Singleton
    fun provideStompWebsocketProviderImpl(
        stompClient: StompClient,
        compositeDisposable: CompositeDisposable
    ): StompWebsocketProviderImpl {
        return StompWebsocketProviderImpl(
            stompClient = stompClient,
            compositeDisposable = compositeDisposable
        )
    }

    @Provides
    @Singleton
    fun provideStompWebsocketProvider(
        stompWebsocketProviderImpl : StompWebsocketProviderImpl
    ) : StompWebsocketProvider{
        return stompWebsocketProviderImpl
    }
}