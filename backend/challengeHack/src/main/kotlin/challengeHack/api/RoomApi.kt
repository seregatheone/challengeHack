package challengeHack.api

import challengeHack.dto.rooms.response.RoomFullDataDto
import challengeHack.dto.rooms.response.RoomsInvitationDtoResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RoomApi {

    suspend fun getRoomInfoById() : Response<RoomFullDataDto>
    @POST("api/v2/room")
    suspend fun createRoom(): Response<RoomFullDataDto>

    @PUT("api/v2/room/{roomId}-{artifact}")
    suspend fun joinInRoom(
        @Path("roomId")
        roomId: Long,
        @Path("artifact")
        artifact: String,
    ): Response<RoomFullDataDto>

    suspend fun getAllInvites() : Response<List<RoomsInvitationDtoResponse>>
}