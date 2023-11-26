package impl.data.providers

import backend.utils.manager.TokenManager

class StompHeadersManager(
    private val tokenManager: TokenManager
) {

    fun getHeaders(): Map<String, String> {
        return mapOf(
            AuthorizationHeader to tokenManager.accessToken
        )
    }

    companion object {
        const val AuthorizationHeader = "Authorization"
    }
}