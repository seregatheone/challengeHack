package backend.utils.interceptors

import backend.utils.exceptions.NetworkError
import backend.utils.manager.TokenManager
import kotlinx.coroutines.*
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.net.HttpURLConnection

class TokenAuthenticator(
    private val tokenManager: TokenManager
) : Authenticator {
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun authenticate(route: Route?, response: Response): Request? {
        if (responseCount(response) == 2 || response.code() >= HttpURLConnection.HTTP_INTERNAL_ERROR) {
            return null
        }

        if (response.request().url().encodedPathSegments().last() == "refresh") {
            scope.launch {
                tokenManager.accessToken = ""
            }
            return null
        }

        val token = scope.async {
            val newTokenResult = tokenManager.updateToken()
            newTokenResult.onSuccess { newToken ->
                tokenManager.accessToken = newToken
            }
            newTokenResult.onFailure { error ->
                if ((error as NetworkError).errorCode in ERROR_CODE) {
                    tokenManager.clear()
                }
            }
            tokenManager.accessToken
        }

        return runBlocking {
            val newToken = token.await().apply {
                if (isEmpty()) return@runBlocking null
            }
            return@runBlocking response.request().newBuilder()
                .header("Authorization", newToken)
                .build()
        }
    }

    private fun responseCount(response: Response?): Int {
        var result = 1
        while (response?.priorResponse() != null) result++
        return result
    }

    companion object {
        private val ERROR_CODE = 401..499
    }
}
