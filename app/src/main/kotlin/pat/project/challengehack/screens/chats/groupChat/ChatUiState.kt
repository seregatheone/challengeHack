package pat.project.challengehack.screens.chats.groupChat

import basic.domain.room.models.ChatMessageEntity


data class ChatUiState(
    val myId : Long? = null,
    val roomId : Long? = null,
    val chatMessages : List<ChatMessageEntity> = emptyList(),
)