package pat.project.challengehack.navigation.bottomNavBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources
import pat.project.challengehack.navigation.BottomNavBarHeadScreens

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navigate: (String) -> Unit,
    currentChildScreen: BottomNavBarHeadScreens?,
    profilePhoto: String? = null
) {
    val density = LocalDensity.current

    AnimatedVisibility(
        visible = currentChildScreen != null,
        enter = slideInVertically(
            animationSpec = spring(
                stiffness = Spring.StiffnessMedium
            ),
            initialOffsetY = { with(density) { 200.dp.roundToPx() } }
        ),
        exit = slideOutVertically(
            animationSpec = spring(
                stiffness = Spring.StiffnessMedium
            ),
            targetOffsetY = { with(density) { 200.dp.roundToPx() } }
        )
    ) {
        BottomNavigation(
            modifier = modifier,
            backgroundColor = AppResources.colors.Black,
            elevation = 2.dp,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomNavBarItemComponent(
                    bottomNavBarHeadScreens = BottomNavBarHeadScreens.Main,
                    isItemSelected = BottomNavBarHeadScreens.Main == currentChildScreen,
                    navigate = navigate,
                    profilePhoto = null
                )
                BottomNavBarItemComponent(
                    bottomNavBarHeadScreens = BottomNavBarHeadScreens.Friends,
                    isItemSelected = BottomNavBarHeadScreens.Friends == currentChildScreen,
                    navigate = navigate,
                    profilePhoto = null
                )
                BottomNavBarItemComponent(
                    bottomNavBarHeadScreens = BottomNavBarHeadScreens.Library,
                    isItemSelected = BottomNavBarHeadScreens.Library == currentChildScreen,
                    navigate = navigate,
                    profilePhoto = null
                )
                BottomNavBarItemComponent(
                    bottomNavBarHeadScreens = BottomNavBarHeadScreens.Profile,
                    isItemSelected = BottomNavBarHeadScreens.Profile == currentChildScreen,
                    navigate = navigate,
                    profilePhoto = profilePhoto
                )

            }

        }
    }
}