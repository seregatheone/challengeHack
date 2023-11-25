package challengeHack.api

import challengeHack.dto.profile.responses.ProfileInfoDto
import retrofit2.Response
import retrofit2.http.GET

interface ProfileApi {
    @GET("api/v2/user")
    suspend fun getProfileInfo() : Response<ProfileInfoDto>


}