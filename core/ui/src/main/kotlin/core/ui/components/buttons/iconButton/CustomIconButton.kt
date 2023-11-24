package core.ui.components.buttons.iconButton

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun CustomIconButton(
    modifier: Modifier = Modifier,
    iconButtonStyle: IconButtonStyles,
    onCLick: () -> Unit,
    color: Color, //= AppResources.colors.LightPurple,
    tint: Color //= AppResources.colors.Black
) {
    IconButton(
        modifier = modifier
            .background(color = color, shape = CircleShape),
        onClick = onCLick,
        interactionSource = MutableInteractionSource()
    ) {
        Icon(
            modifier = Modifier.padding(8.dp),
            imageVector = iconButtonStyle.icon,
            contentDescription = null,
            tint = tint,
        )
    }
}