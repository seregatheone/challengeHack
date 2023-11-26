package websockets.basics

import ua.naiksoftware.stomp.dto.StompHeader

object StompClientConfig {
    const val clientHeartbeat = 10000
    const val serverHeartbeat = 10000
    fun getChatListeningUrl(roomId: Long) = "/app/queue/room/$roomId/chat"
    fun getChatSendingUrl(roomId: Long) = "/app/room/$roomId/chat"
}