package challengeHack.api

import challengeHack.dto.auth.request.LoginDto
import challengeHack.dto.auth.request.RefreshTokenDto
import challengeHack.dto.auth.request.RegistrationDto
import backend.conversay.dto.auth.response.TokensResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("api/v2/refresh")
    suspend fun updateToken(
        @Body refresh : RefreshTokenDto
    ) : Response<TokensResponse>

    @GET("api/v2/verify-access")
    suspend fun verifyAccess() : Response<Unit>

    @GET("api/v2/logout")
    suspend fun logout() : Response<Unit>

    @GET("api/v2/logout-all-sessions")
    suspend fun logoutAllSessions() : Response<Unit>

    @POST("api/v2/auth")
    suspend fun registration(
        @Body registrationDto: RegistrationDto
    ) : Response<TokensResponse>

    @POST("api/v2/login")
    suspend fun login(
        @Body loginDto: LoginDto
    ) : Response<TokensResponse>

}