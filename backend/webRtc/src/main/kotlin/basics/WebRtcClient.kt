package basics

object WebRtcClient {
    fun getWebRtcSubscription(conversationId: Int) = "/app/queue/conversation/$conversationId"
    fun getWebRtcSendingUrl(conversationId: Int) = "/app/conversation/$conversationId"
}