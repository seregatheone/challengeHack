package core.ui.components.buttons.filled

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun FilledColorRoundedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonStyle: FilledButtonStyles = FilledButtonStyles.YELLOW,
    text: String,
    width: Dp = 240.dp,
    height: Dp = 60.dp,
    cornersRadius: Dp = height / 2
) {
    Button(
        modifier = modifier.size(
            width = width,
            height = height
        ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
//            backgroundColor = when (buttonStyle) {
//                FilledButtonStyles.PURPLE -> AppResources.colors.DarkOnPurple
//                FilledButtonStyles.YELLOW -> AppResources.colors.YellowGold
//                FilledButtonStyles.PURPLE_LIGHT -> AppResources.colors.LightPurple
//            }
        ),
        shape = RoundedCornerShape(cornersRadius),
        interactionSource = MutableInteractionSource()
    ) {
        Text(
            text = text,
//            color = when (buttonStyle) {
//                FilledButtonStyles.PURPLE -> AppResources.colors.White
//                FilledButtonStyles.YELLOW -> AppResources.colors.DarkPurple
//                FilledButtonStyles.PURPLE_LIGHT -> AppResources.colors.White
//            },
//            style = AppResources.typography.titles.title0
        )
    }
}