package pat.project.challengehack.navigation.bottomNavBar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import core.ui.themes.AppResources
import pat.project.challengehack.navigation.BottomNavBarHeadScreens


@Composable
fun BottomNavBarItemComponent(
    modifier: Modifier = Modifier,
    bottomNavBarHeadScreens: BottomNavBarHeadScreens,
    isItemSelected: Boolean,
    navigate: (String) -> Unit,
    profilePhoto : String?
) {


    Box(modifier = modifier
        .clickable(
            indication = null,
            interactionSource = MutableInteractionSource(),
            onClick = {
                navigate(bottomNavBarHeadScreens.route)
            }
        ),
        contentAlignment = Alignment.Center
    ) {
        if(profilePhoto != null && bottomNavBarHeadScreens == BottomNavBarHeadScreens.Profile){
            AsyncImage(
                modifier = modifier
                    .size(36.dp)
                    .clip(shape = CircleShape)
                    .background(color = AppResources.colors.MainRed , shape = CircleShape)
                    .border(
                        width = if (isItemSelected) 2.dp else 0.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(profilePhoto)
                    .decoderFactory(SvgDecoder.Factory())
                    .placeholder(bottomNavBarHeadScreens.bottomNavIcon.iconId)
                    .build(),
                contentDescription = null
            )
        }else{
            Icon(
                painter = painterResource(id = bottomNavBarHeadScreens.bottomNavIcon.iconId),
                tint = if (isItemSelected) AppResources.colors.MainRed else Color.Unspecified,
                contentDescription = null
            )
        }
    }
}