package basics

object WebRtcClient {
    fun getWebRtcSubscription(conversationId: String) = "/app/queue/conversation/$conversationId"
    fun getWebRtcSendingUrl(conversationId: String) = "/app/conversation/$conversationId"
}