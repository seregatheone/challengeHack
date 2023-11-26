package pat.project.challengehack.screens.rooms.roomScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources
import pat.project.challengehack.R


@Composable
fun AddParticipantIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .size(52.dp)
            .background(
                color = AppResources.colors.Grey70,
                shape = CircleShape
            ),
        onClick = onClick,
        interactionSource = MutableInteractionSource()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_plus_icon),
            contentDescription = null
        )
    }
}