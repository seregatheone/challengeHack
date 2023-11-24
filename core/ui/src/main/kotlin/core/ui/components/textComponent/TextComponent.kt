package core.ui.components.textComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    value: String,
    shape: RoundedCornerShape = RoundedCornerShape(12.dp),
    color: Color = AppResources.colors.MainRed
) {
    BasicText(
        text = value,
        maxLines = 1,
        style = AppResources.typography.titles.title1.copy(color = AppResources.colors.White),
        modifier = modifier
            .background((color), shape = shape),
    )
}