package pat.project.challengehack.screens.container

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import pat.project.challengehack.navigation.bottomNavBar.BottomNavBar
import pat.project.challengehack.navigation.utils.currentChildScreen

@Composable
fun ContainerScreen(
    modifier: Modifier = Modifier,
    viewModel: ContainerViewModel = hiltViewModel(),
    navController : NavController,
    navigation: @Composable (modifier : Modifier) -> Unit
) {

//    val websocketService = LocalWebsocketConnector.current
//    val webRtcConnector = LocalWebRtcDataConnector.current

//    val lifecycleOwner = LocalLifecycleOwner.current
//    DisposableEffect(lifecycleOwner) {
//        // Create an observer that triggers our remembered callbacks
//        // for sending analytics events
//        val observer = LifecycleEventObserver { _, event ->
//            when (event) {
//                Lifecycle.Event.ON_CREATE -> {
//                    websocketService.initStompWebsocket()
//                    webRtcConnector.connectToWebRtc()
//                }
//
//                Lifecycle.Event.ON_RESUME -> {
//                    websocketService.reconnectStompWebsocket()
//                }
//
//                Lifecycle.Event.ON_DESTROY -> {
//                    websocketService.disconnectStompWebsocket()
//                }
//
//                else -> {
//
//                }
//            }
//        }
//
//        // Add the observer to the lifecycle
//        lifecycleOwner.lifecycle.addObserver(observer)
//
//        // When the effect leaves the Composition, remove the observer
//        onDispose {
//            lifecycleOwner.lifecycle.removeObserver(observer)
//        }
//    }

    val profilePhoto by viewModel.profileImage.collectAsState()

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        bottomBar = {
            BottomNavBar(
                modifier = Modifier.fillMaxWidth(),
                navigate = { destination ->
                    navController.navigate(destination){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                currentChildScreen = navController.currentChildScreen(),
                profilePhoto = profilePhoto
            )
        }
    ) {paddingValues ->
        navigation(
            Modifier.fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        )
    }

}