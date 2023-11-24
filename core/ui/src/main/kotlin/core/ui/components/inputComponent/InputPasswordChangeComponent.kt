package core.ui.components.inputComponents.inputComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun InputPasswordChangeComponent(
    modifier: Modifier = Modifier,
    backgroundColor: Color,// = AppResources.colors.PurpleGreyMedium,
    onPasswordChange: () -> Unit
){
    BasicText(text = "***************",
        style = (AppResources.typography.titles.title1.copy(
            color = AppResources.colors.White
        )),
        modifier = modifier
            .clickable { onPasswordChange() }
            .background(
                (backgroundColor),
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .padding(start = 36.dp, top = 9.dp, bottom = 9.dp))

}
