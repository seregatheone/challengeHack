package pat.project.challengehack.screens.rooms.roomScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.components.buttons.iconButton.CustomIconButton
import core.ui.components.buttons.iconButton.IconButtonStyles
import core.ui.themes.AppResources

@Composable
fun RoomBottomBar(
    modifier : Modifier = Modifier,
    navigateToChat : () -> Unit,
    isMicroOn : Boolean,
    toggleMicro : () -> Unit,
    isVolumeOn : Boolean,
    toggleVolume : () -> Unit,
    onFinishAndLeave: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = AppResources.colors.Black)
            .padding(start = 23.dp, end = 23.dp, top = 20.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomIconButton(
            iconButtonStyle = IconButtonStyles.MESSAGE,
            onCLick = navigateToChat,
            color = AppResources.colors.Grey90,
            modifier = Modifier
        )

        CustomIconButton(
            iconButtonStyle = if (isMicroOn) IconButtonStyles.MIC else IconButtonStyles.MICOFF,
            onCLick = toggleMicro,
            color = if (isMicroOn) AppResources.colors.Grey90 else AppResources.colors.Grey70,
            modifier = Modifier,
            tint = AppResources.colors.White
        )
        CustomIconButton(
            iconButtonStyle = if(isVolumeOn) IconButtonStyles.VOLUME else IconButtonStyles.VOLUMEOFF,
            onCLick = toggleVolume,
            color = if (isMicroOn) AppResources.colors.Grey90 else AppResources.colors.Grey70,
            modifier = Modifier,
            tint = AppResources.colors.White
        )
        CustomIconButton(
            iconButtonStyle = IconButtonStyles.PHONE,
            onCLick = onFinishAndLeave,
            color = AppResources.colors.Grey90,
            modifier = Modifier,
            tint = AppResources.colors.White
        )
    }
}