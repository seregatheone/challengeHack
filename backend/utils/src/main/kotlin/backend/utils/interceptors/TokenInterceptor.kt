package backend.utils.interceptors

import backend.utils.manager.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import kotlinx.coroutines.runBlocking

class TokenInterceptor(
    private val tokenManager: TokenManager
):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        runBlocking {
            val token = tokenManager.accessToken
            token.let {
                val finalToken = it
                request = request.newBuilder()
                    .addHeader("Authorization", finalToken)
                    .build()
            }
        }
        return chain.proceed(request)
    }
}