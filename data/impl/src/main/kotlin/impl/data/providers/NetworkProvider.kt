package impl.data.providers

import backend.utils.interceptors.TokenAuthenticator
import backend.utils.interceptors.TokenInterceptor
import backend.utils.manager.TokenManager
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pat.project.challengehack.data.impl.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkProvider(
    private val host: String,
    private val tokenManager: TokenManager,
) {
    private val client = OkHttpClient.Builder().apply {
        readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
        connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
//        authenticator(TokenAuthenticator(tokenManager))
        addInterceptor(TokenInterceptor(tokenManager))
        if (BuildConfig.DEBUG) {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }
    }.build()

    fun <T> provideRetrofit(
        clazz: Class<T>,
    ): T {
        return Retrofit.Builder()
            .baseUrl(host)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()
            .create(clazz)
    }

    companion object {
        private const val CONNECT_TIME_OUT: Long = 30
        private const val READ_TIME_OUT: Long = 15
    }
}
