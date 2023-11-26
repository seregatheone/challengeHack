package pat.project.challengehack.navigation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pat.project.challengehack.navigation.BottomNavBarHeadScreens

fun NavGraphBuilder.composable(
    screen: BottomNavBarHeadScreens,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = screen.route,
        arguments = arguments,
        deepLinks = deepLinks,
        content = content,
    )
}

@Composable
fun NavController.currentChildScreen(): BottomNavBarHeadScreens? {
    val state by currentBackStackEntryFlow.collectAsState(null)
    return state?.destination?.route?.let { BottomNavBarHeadScreens.getScreen(it) }
}
