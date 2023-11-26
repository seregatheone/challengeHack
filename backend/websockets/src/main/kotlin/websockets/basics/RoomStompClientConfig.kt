package websockets.basics

object  RoomStompClientConfig {
    fun getRoomAcceptUrl(roomId: Long) = "/room/$roomId/users/offer/accept"
    fun getRoomDeclineUrl(roomId: Long) = "/room/$roomId/users/offer/decline"

    fun getListeningInvitesUrl() = "/app/queue/room/invites"
}