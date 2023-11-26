package pat.project.challengehack.screens.rooms.roomsScreenStart

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.hilt.navigation.compose.hiltViewModel
import core.ui.components.buttons.filled.FilledColorRoundedButton
import core.ui.themes.AppResources
import pat.project.challengehack.LocalWebRtcDataConnector
import pat.project.challengehack.MainActivity
import pat.project.challengehack.R
import pat.project.challengehack.screens.rooms.roomsScreenStart.components.InvitationComponent
import pat.project.challengehack.screens.rooms.roomsScreenStart.models.RoomsNavDirections

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RoomsStartScreen(
    modifier: Modifier = Modifier,
    viewModel: RoomsStartScreenViewModel = hiltViewModel(),
    navigateToRoomScreen: (Long) -> Unit
) {

    val context = LocalContext.current

    val roomUiState by viewModel.roomUiState.collectAsState()
    val roomsNavDirections by viewModel.roomsNavDirections.collectAsState()

    LaunchedEffect(key1 = roomsNavDirections) {
        when (roomsNavDirections) {
            RoomsNavDirections.Default -> {}
            is RoomsNavDirections.RoomScreen -> {
                navigateToRoomScreen((roomsNavDirections as RoomsNavDirections.RoomScreen).roomId)
            }
        }
    }

    val launchCameraPermission = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permission ->
        var isGranted = true
        permission.entries.forEach {
            if (!it.value) isGranted = false
        }
        if (isGranted) {
            try {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivityForResult(context as MainActivity, takePictureIntent, 1, null)
                } catch (e: ActivityNotFoundException) {
                    // display error state to the user
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    Scaffold(
        modifier = modifier
            .background(color = AppResources.colors.Black),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = AppResources.colors.Black)
                    .padding(top = 12.dp, bottom = 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    tint = AppResources.colors.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }

    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .background(color = AppResources.colors.Black)
                .padding(horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        modifier = Modifier.padding(bottom = 24.dp),
                        text = stringResource(id = R.string.room_text),
                        style = AppResources.typography.headlines.headline0,
                        color = AppResources.colors.White
                    )
                    FilledColorRoundedButton(
                        modifier = Modifier
                            .width(148.dp)
                            .height(40.dp),
                        cornersRadius = 8.dp,
                        onClick = {
                            viewModel.createRoom()
                        },
                        text = stringResource(id = R.string.create_room)
                    )
                }

                Icon(
                    modifier = Modifier.clickable(
                        onClick = {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                launchCameraPermission.launch(
                                    arrayOf(
                                        Manifest.permission.CAMERA,
                                        Manifest.permission.READ_MEDIA_IMAGES,
                                    )
                                )
                            } else {
                                launchCameraPermission.launch(
                                    arrayOf(
                                        Manifest.permission.CAMERA,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                    )
                                )
                            }
                        }
                    ),
                    painter = painterResource(id = R.drawable.ic_connect_by_qr),
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = stringResource(id = R.string.invitations_text),
                style = AppResources.typography.headlines.headline1,
                color = AppResources.colors.White
            )

            LazyColumn(
                modifier = Modifier.padding(top = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(roomUiState.invitationList) { item ->
                    InvitationComponent(
                        invitationEntity = item,
                        acceptInvitation = {},
                        declineInvitation = {},
                    )
                }

            }
        }

    }
}
