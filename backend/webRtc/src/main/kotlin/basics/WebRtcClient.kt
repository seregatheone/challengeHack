package basics

object WebRtcClient {
    fun getWebRtcSubscription(roomId: Long) = "/app/queue/room/$roomId/voiceChat"
    fun getWebRtcSendingUrl(roomId: Long) = "/app/conversation/$roomId"
}