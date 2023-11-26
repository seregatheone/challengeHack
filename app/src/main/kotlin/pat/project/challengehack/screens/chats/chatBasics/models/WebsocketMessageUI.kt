package pat.project.challengehack.screens.chats.chatBasics.models

import java.time.LocalDateTime

data class WebsocketMessageUI(
    val messageTime : LocalDateTime,
    val messageIsMine : Boolean,
    val messageText : String,
    val messagePhoto: String
)