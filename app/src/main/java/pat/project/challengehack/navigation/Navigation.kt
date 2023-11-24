package pat.project.challengehack.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()


//    NavHost(
//        modifier = modifier,
//        navController = navController,
//        startDestination = Screens.FeatureLoading.screenRoute,
//    ) {
//    }
}


sealed class Screens(
    val screenRoute: String
) {

    abstract val arguments: List<NamedNavArgument>
}