package websockets.basics

import ua.naiksoftware.stomp.dto.StompHeader

object StompClientConfig {
    const val clientHeartbeat = 3000
    const val serverHeartbeat = 3000
    fun getChatListeningUrl(chatId: Int) = "/app/queue/chat/$chatId/messages"
    fun getChatSendingUrl(chatId: Int) = "/app/chat/$chatId"
}