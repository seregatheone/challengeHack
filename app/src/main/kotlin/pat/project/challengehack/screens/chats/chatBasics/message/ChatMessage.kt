package pat.project.challengehack.screens.chats.chatBasics.message

import java.time.LocalDateTime

sealed class ChatMessage(
    val messageDate: LocalDateTime,
    val messageBody: String,
    val photoUrl: String
) {
    class MyMessage(
        messageDate: LocalDateTime,
        messageBody: String,
        photoUrl: String
    ) : ChatMessage(
        messageDate,
        messageBody,
        photoUrl
    )

    class InterlocutorMessage(
        messageDate: LocalDateTime,
        messageBody: String,
        photoUrl: String
    ) : ChatMessage
        (
        messageDate,
        messageBody,
        photoUrl
    )
}