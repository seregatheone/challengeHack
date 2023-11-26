package core.ui.components.buttons.outlined

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun OutlinedRoundedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
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
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Unspecified,
            disabledBackgroundColor = Color.Transparent,
            contentColor = AppResources.colors.White
        ),
        border = BorderStroke(1.dp, AppResources.colors.White),
        shape = RoundedCornerShape(cornersRadius),
        interactionSource = MutableInteractionSource()
    ) {
        Text(
            text = text,
            style = AppResources.typography.titles.title0
        )
    }
}