package websockets.basics

object  RoomStompClientConfig {
    fun getRoomAcceptUrl(roomId: Long) = "/room/$roomId/users/offer/accept"
    fun getRoomDeclineUrl(roomId: Long) = "/room/$roomId/users/offer/decline"

    fun getListeningInvitesUrl() = "/app/queue/room/invites"

    fun getTrackListeningUrl(roomId: Long) = "/app/queue/room/$roomId/tracks"

    fun getAddToQueueTrack(roomId: Long) = "/app/room/$roomId/tracks/add"

    fun getNewUsersListeningUrl(roomId: Long) = "/app/queue/room/$roomId/users"
}