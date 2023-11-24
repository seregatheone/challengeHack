package pat.project.challengehack.screens.friends.friendsScreen.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun ClickableCardTextWithIcon(
    modifier: Modifier,
    @StringRes
    text: Int,
//    color: Color = AppResources.colors.PurpleDark,
//    icon: IconButtonStyles,
    onClick: () -> Unit
) {
//    Row(
//        modifier = modifier
//            .clickable(
//                indication = null,
//                interactionSource = MutableInteractionSource(),
//                onClick = onClick
//            )
//            .background(
//                color = color,
//                shape = RoundedCornerShape(12.dp)
//            )
//            .fillMaxWidth()
//            .padding(start = 18.dp, end = 18.dp, top = 15.dp, bottom = 15.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            CustomIconButton(
//                iconButtonStyle = icon,
//                onCLick = onClick,
//                modifier = Modifier
//            )
//            Text(
//                text = stringResource(id = text),
//                modifier = Modifier.padding(start = 12.dp),
//                style = AppResources.typography.body.body0,
//                color = AppResources.colors.White
//            )
//        }
//        Icon(
//            imageVector = Icons.Default.ArrowForwardIos,
//            contentDescription = null,
//            tint = Color.White
//        )
//    }

}