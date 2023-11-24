package core.ui.components.buttons.outlined

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.ui.components.buttons.filled.FilledButtonStyles
import core.ui.themes.AppResources


@Composable
fun OutlinedSmallRoundedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    width: Dp = 140.dp,
    height: Dp = 27.dp,
    cornersRadius: Dp = 8.dp
) {
    BasicTextField(
        modifier = modifier
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = MutableInteractionSource()
            ),
        value = text,
        readOnly = true,
        onValueChange = {},
        decorationBox = { innerText ->
            Box(
                modifier = Modifier
                    .size(
                        width = width,
                        height = height
                    )
                    .border(
                        width = 1.dp,
                        color = AppResources.colors.White,
                        shape = RoundedCornerShape(cornersRadius)
                    )
                    .clickable(
                        onClick = onClick,
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    ),
                contentAlignment = Alignment.Center
            ) {
                innerText()
            }
        },
        textStyle = AppResources.typography.label.label1.copy(
            color = AppResources.colors.White
        )
    )
}