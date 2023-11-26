package pat.project.challengehack.screens.chats.chatBasics.message

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
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
                AsyncImage(
                    modifier = modifier
                        .padding(start = 4.dp)
                        .background(
                            color = AppResources.colors.Grey80,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(chatMessage.photoUrl)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = null
                )

            }
        }

        is ChatMessage.InterlocutorMessage -> {
            Row(
                modifier = modifier
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                AsyncImage(
                    modifier = modifier
                        .padding(start = 4.dp)
                        .background(
                            color = AppResources.colors.Grey80,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .size(30.dp),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(chatMessage.photoUrl)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = null
                )
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