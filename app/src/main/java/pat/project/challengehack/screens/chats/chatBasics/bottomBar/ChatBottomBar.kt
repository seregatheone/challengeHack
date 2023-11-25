package pat.project.challengehack.screens.chats.chatBasics.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources
import pat.project.challengehack.R

@Composable
fun ChatBottomBar(
    modifier: Modifier = Modifier,
    sendMessage: (String) -> Unit
) {

    var message by remember {
        mutableStateOf("")
    }

    val sendButtonState = remember(message) {
        if (message.trim().isEmpty()) {
            ButtonState.Disabled
        } else {
            ButtonState.None
        }

    }

    var messageFieldFocused by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp,
                vertical = 18.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            modifier = Modifier
                .weight(1f)
                .onFocusChanged { isFocused ->
                    messageFieldFocused = isFocused.isFocused
                }
                .sizeIn(minHeight = 36.dp),
            value = message,
            onValueChange = { newValue ->
                message = newValue
            },
            textStyle = AppResources.typography.body.body1.copy(
                color = AppResources.colors.White
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp
                        )
                        .background(
                            color = AppResources.colors.Grey90_60,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .padding(
                                horizontal = 12.dp,
                                vertical = 12.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (message.isEmpty() && !messageFieldFocused) {
                            Text(
                                text = stringResource(id = R.string.chat_message_placeholder),
                                style = AppResources.typography.titles.title1.copy(
                                    color = AppResources.colors.Grey80
                                )
                            )
                        } else {
                            innerTextField()
                        }
                    }

                }
            },
            cursorBrush = Brush.verticalGradient(
                listOf(
                    AppResources.colors.White,
                    AppResources.colors.White
                )
            )
        )
        Icon(
            modifier = Modifier
                .padding(10.dp)
                .size(24.dp)
                .clickable(
                    indication = null,
                    interactionSource = MutableInteractionSource(),
                    onClick = {
                        sendMessage(message)
                        message = ""
                    }
                ),
            imageVector = Icons.Default.Send,
            tint = if (sendButtonState == ButtonState.None) AppResources.colors.White
            else AppResources.colors.Grey60,
            contentDescription = null
        )
    }
}
