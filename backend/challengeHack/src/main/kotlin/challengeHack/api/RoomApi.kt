package challengeHack.api

import challengeHack.dto.profile.request.ProfileIdsDto
import challengeHack.dto.profile.responses.ProfilesDto
import challengeHack.dto.rooms.response.RoomFullDataDto
import challengeHack.dto.rooms.response.RoomsInvitationDtoResponse
import challengeHack.dto.rooms.response.UserProfileDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RoomApi {
    @GET("api/v2/room")
    suspend fun getRoomInfoById(
        @Query("roomId") roomId: Long) : Response<RoomFullDataDto>
    @POST("api/v2/room")
    suspend fun createRoom(): Response<RoomFullDataDto>
    @POST("api/v2/user/profiles")
    suspend fun getUsersById(
        @Body profileIdsDto: ProfileIdsDto
    ): Response<ProfilesDto>

    @PUT("api/v2/room/{roomId}")
    suspend fun joinInRoom(
        @Path("roomId")
        roomId: Long,
    ): Response<RoomFullDataDto>

    suspend fun getAllInvites() : Response<List<RoomsInvitationDtoResponse>>

    @GET("api/v2/music/track/{url}")
    suspend fun getHlsMusicStream(
        @Path("url")
        m3u8Url : String
    ): Response<ResponseBody>
}