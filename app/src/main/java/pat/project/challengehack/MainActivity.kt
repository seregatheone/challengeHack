package pat.project.challengehack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import core.ui.components.snackbar.SnackBarComponent
import core.ui.components.snackbar.SnackBarStyle
import core.ui.themes.AppResources
import core.ui.themes.ChallengeHackTheme
import dagger.hilt.android.AndroidEntryPoint
import impl.data.errorbroadcast.ErrorStatus
import impl.data.errorbroadcast.LocalBroadcastManager
import kotlinx.coroutines.launch
import pat.project.challengehack.navigation.Navigation


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val error = LocalBroadcastManager.error.collectAsState(ErrorStatus.Default)
            val snackState = remember { SnackbarHostState() }
            val coroutineScope = rememberCoroutineScope()

            LaunchedEffect(key1 = error.value) {
                if (error.value !is ErrorStatus.Default) {
                    coroutineScope.launch {
                        snackState.showSnackbar(
                            message = error.value.message,
                            duration = SnackbarDuration.Short
                        )
                    }
                    LocalBroadcastManager.clear()
                }
            }

            ChallengeHackTheme {
                WindowCompat.setDecorFitsSystemWindows(window, false)
//                window.statusBarColor = AppResources.colors.SystemHeader.toArgb()

                Box(Modifier.fillMaxSize()) {

                    Navigation(
                        modifier = Modifier
                            .fillMaxSize()
                    )

                    SnackbarHost(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 48.dp)
                            .padding(horizontal = 20.dp),
                        hostState = snackState
                    ) { snackBarData: SnackbarData ->
                        SnackBarComponent(
                            modifier = Modifier.fillMaxWidth(),
                            message = snackBarData.visuals.message,
                            snackBarStyle = SnackBarStyle.RedStyle
                        )
                    }
                }

            }
        }
    }
}
