package core.ui.components.buttons.filled

import androidx.compose.foundation.background
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
import core.ui.themes.AppResources


@Composable
fun FilledColorSmallRoundedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonStyle: FilledButtonStyles = FilledButtonStyles.YELLOW,
    text: String,
    width: Dp = 140.dp,
    height: Dp = 27.dp,
    cornersRadius: Dp = 6.dp
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
//                    .background(
//                        color = when (buttonStyle) {
//                            FilledButtonStyles.PURPLE -> AppResources.colors.DarkOnPurple
//                            FilledButtonStyles.YELLOW -> AppResources.colors.YellowGold
//                            FilledButtonStyles.PURPLE_LIGHT -> AppResources.colors.LightPurple
//
//                        },
//                        shape = RoundedCornerShape(cornersRadius)
//                    )
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
//        textStyle = AppResources.typography.label.label1.copy(
//            color = when (buttonStyle) {
//                FilledButtonStyles.PURPLE -> AppResources.colors.White
//                FilledButtonStyles.YELLOW -> AppResources.colors.DarkPurple
//                FilledButtonStyles.PURPLE_LIGHT -> AppResources.colors.White
//            }
//        )
    )

}