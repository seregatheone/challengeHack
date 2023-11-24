package impl.data.managers


import backend.utils.manager.TokenManager
import com.google.gson.GsonBuilder
import impl.data.store.AuthorizationStore
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pat.project.challengehack.data.impl.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TokenManagerImpl(
    private val store: AuthorizationStore,
    private val host: String,
) : TokenManager {
//    private val authorizationApi: AuthApi = getRetrofit().create(AuthApi::class.java)
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(host).client(
            OkHttpClient.Builder().apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                }
            }.build()
        )
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()
    }

    override var accessToken: String
        get() = runBlocking {
            store.accessToken
        }
        set(value) {
            runBlocking {
                store.accessToken = value
            }
        }
    override var refreshToken: String
        get() = store.refreshToken
        set(value) {
            store.refreshToken = value
        }

    override fun clear() {
        store.clearTokens()
    }

    override suspend fun updateToken(): Result<String> {
        return Result.failure(Error(""))
//        val response = try {
//            authorizationApi.updateToken(RefreshTokenDto(refreshToken))
//        } catch (e: IOException) {
//            return Result.failure(NetworkError(0))
//        }
//        if (response.isSuccessful) {
//            try {
//                val body = response.body()!!
//                refreshToken = body.refreshToken
//                return Result.success(body.accessToken)
//            }
////            catch (e: NullPointerException) {
////                if (BuildConfig.DEBUG) {
////                    Log.i
////                }
////            }
//            catch (e: Exception) {
//                if (BuildConfig.DEBUG) {
//                    Log.i(
//                        "updateToken in api",
//                        e.message.toString()
//                    )
//                }
//            }
//        }
//        return Result.failure(NetworkError(response.code()))
    }
}
