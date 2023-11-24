package pat.project.challengehack.screens.authRegLoading.featureloading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import core.ui.themes.AppResources
import pat.project.challengehack.screens.authRegLoading.featureloading.FeatureLoadingViewModel
import pat.project.challengehack.screens.authRegLoading.featureloading.models.FeatureLoadingNavigationDestination

@Composable
fun FeatureLoadingScreen(
    modifier: Modifier = Modifier,
    viewModel: FeatureLoadingViewModel = hiltViewModel(),
    navigateToWelcomePage: () -> Unit,
    navigateToMainScreen: () -> Unit,
) {
    val navigationDestination by viewModel.navDestination.collectAsState()
    LaunchedEffect(key1 = navigationDestination){
        when(navigationDestination){
            FeatureLoadingNavigationDestination.Default -> {}
            FeatureLoadingNavigationDestination.WelcomePage -> {
                navigateToWelcomePage()
            }
            FeatureLoadingNavigationDestination.Main -> {
                navigateToMainScreen()
            }
        }
    }
    Box(
        modifier = modifier
            .background(Color.White)
    ) {
        Text("123", color = Color.Black)
        CircularProgressIndicator(
            modifier = Modifier
                .width(82.dp)
                .align(Alignment.Center),
            color = Color.Red,
            strokeWidth = 6.dp
        )
    }
}