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
    buttonStyle: FilledButtonStyles = FilledButtonStyles.MAINRED,
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
            backgroundColor = when (buttonStyle) {
                FilledButtonStyles.MAINRED -> AppResources.colors.MainRed
                FilledButtonStyles.GREY60 -> AppResources.colors.Grey60
            }
        ),
        shape = RoundedCornerShape(cornersRadius),
        interactionSource = MutableInteractionSource()
    ) {
        Text(
            text = text,
            color = AppResources.colors.White,
            style = AppResources.typography.titles.title0
        )
    }
}