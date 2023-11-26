package pat.project.challengehack

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Color.toArgb
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import core.ui.components.snackbar.SnackBarComponent
import core.ui.components.snackbar.SnackBarStyle
import core.ui.themes.AppResources
import core.ui.themes.ChallengeHackTheme
import dagger.hilt.android.AndroidEntryPoint
import impl.data.errorbroadcast.ErrorStatus
import impl.data.errorbroadcast.LocalBroadcastManager
import impl.data.managers.WebRtcSessionManager
import impl.data.providers.WebRtcDataConnector
import impl.data.providers.WebsocketStompDataConnector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import pat.project.challengehack.navigation.Navigation
import pat.project.challengehack.services.websocket.WebsocketService
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var disposableLifecycle: Disposable

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    private var mBound = false

    private val _mService = MutableSharedFlow<WebsocketService>()
    private val mService = _mService.asSharedFlow()

    private val coroutineScopeForService = CoroutineScope(Dispatchers.Default)

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as WebsocketService.LocalBinder
            coroutineScopeForService.launch {
                _mService.emit(binder.getService())
            }
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, WebsocketService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val error = LocalBroadcastManager.error.collectAsState(ErrorStatus.Default)
            val snackState = remember { SnackbarHostState() }
            val coroutineScope = rememberCoroutineScope()

            var service : WebsocketService? by remember {
                mutableStateOf(null)
            }

            LaunchedEffect(key1 = Unit) {
                coroutineScopeForService.launch {
                    mService.collect {
                        service = it
                        coroutineScopeForService.cancel("Service started")
                    }
                }
            }

            compositeDisposable.add(disposableLifecycle)

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
                window.statusBarColor = Color.Black.toArgb()

                Box(Modifier.fillMaxSize()) {

                    if (service != null) {
                        Box(Modifier.fillMaxSize()) {
                            CompositionLocalProvider(
                                LocalWebsocketConnector provides service!!,
                                LocalSessionManager provides service!!.sessionManager,
                                LocalWebRtcDataConnector provides service!!
                            ) {
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
                    else{
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .width(82.dp)
                                    .align(Alignment.Center),
                                color = Color.White,
                                strokeWidth = 6.dp
                            )
                        }
                    }


                }

            }
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBound = false
    }
}


val LocalWebsocketConnector =
    compositionLocalOf<WebsocketStompDataConnector> { error("No WebsocketService found!") }

val LocalWebRtcDataConnector =
    compositionLocalOf<WebRtcDataConnector> { error("No WebsocketService found!") }

val LocalSessionManager =
    compositionLocalOf<WebRtcSessionManager> { error("No WebsocketService found!") }

