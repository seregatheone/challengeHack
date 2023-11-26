package backend.utils.manager

interface TokenManager {
    var accessToken: String
    var refreshToken: String
    suspend fun updateToken(): Result<String>
    fun clear()
}
