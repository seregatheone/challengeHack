package pat.project.challengehack.screens.chats.chatBasics.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.ui.components.buttons.iconButton.CustomIconButton
import core.ui.components.buttons.iconButton.IconButtonStyles
import core.ui.themes.AppResources
import pat.project.challengehack.R


@Composable
fun MessengerTopAppBar(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = AppResources.colors.Black)
            .padding(top = 12.dp, bottom = 20.dp)
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_charm_arrow_up),
            contentDescription = null,
            tint = AppResources.colors.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
        )

        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            tint = AppResources.colors.White,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable (
                    indication = null,
                    interactionSource = MutableInteractionSource(),
                    onClick = onBackPressed
                )
        )
    }
}