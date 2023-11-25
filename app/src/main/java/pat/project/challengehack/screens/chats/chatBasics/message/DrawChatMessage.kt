package pat.project.challengehack.screens.chats.chatBasics.message

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources
import utils.time.toFormattedStringOnlyHoursMinutes


@Composable
fun DrawChatMessage(
    modifier: Modifier = Modifier,
    chatMessage: ChatMessage,
) {
    when (chatMessage) {
        is ChatMessage.MyMessage -> {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                Card(
                    modifier = Modifier
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(12.dp),
                    backgroundColor = AppResources.colors.Grey90
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom
                    ) {
                        MessageContent(
                            modifier = Modifier,
                            messageContent = chatMessage.messageBody,
                        )
                        Text(
                            modifier = Modifier.padding(end = 6.dp),
                            text = chatMessage.messageDate.toFormattedStringOnlyHoursMinutes(),
                            style = AppResources.typography.body.body1.copy(
                                color = AppResources.colors.White
                            ),
                        )
                    }
                }

            }
        }

        is ChatMessage.InterlocutorMessage -> {
            Row(
                modifier = modifier
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Card(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = 0.dp,
                    backgroundColor = AppResources.colors.Grey90_60
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom
                    ) {
                        MessageContent(
                            modifier = Modifier,
                            messageContent = chatMessage.messageBody,
                        )
                        Text(
                            modifier = Modifier.padding(end = 6.dp),
                            text = chatMessage.messageDate.toFormattedStringOnlyHoursMinutes(),
                            style = AppResources.typography.body.body1.copy(
                                color = AppResources.colors.White
                            )
                        )
                    }
                }
            }
        }
    }
}