package challengeHack.api

import challengeHack.dto.rooms.response.RoomFullDataDto
import challengeHack.dto.rooms.response.RoomsInvitationDtoResponse
import retrofit2.Response
import retrofit2.http.POST

interface RoomApi {

    suspend fun getRoomInfoById() : Response<RoomFullDataDto>
    @POST("api/v2/room")
    suspend fun createRoom(): Response<RoomFullDataDto>
    suspend fun getAllInvites() : Response<List<RoomsInvitationDtoResponse>>
}