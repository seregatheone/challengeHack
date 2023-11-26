package pat.project.challengehack.screens.rooms.roomScreen

import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType
import core.ui.components.listItems.OfferItem
import core.ui.components.listItems.QueueItem
import core.ui.components.listItems.TrackItem
import core.ui.themes.AppResources
import pat.project.challengehack.LocalSessionManager
import pat.project.challengehack.LocalWebsocketConnector
import pat.project.challengehack.R
import pat.project.challengehack.navigation.Screens.Companion.ARTIFACT
import pat.project.challengehack.navigation.Screens.Companion.ROOM_ID
import pat.project.challengehack.screens.rooms.roomScreen.components.AddParticipantIcon
import pat.project.challengehack.screens.rooms.roomScreen.components.ParticipantImageAndName
import pat.project.challengehack.screens.rooms.roomScreen.components.RoomBottomBar
import pat.project.challengehack.screens.rooms.roomScreen.models.RoomNavDirection
import pat.project.challengehack.screens.rooms.roomScreen.models.TabModel


@Composable
fun RoomScreen(
    modifier: Modifier = Modifier,
    viewModel: RoomViewModel = hiltViewModel(),
    roomId: Long,
    navigateToChat: (Long) -> Unit,
    onClickBack: () -> Unit,
    artifact: String
) {
//    LaunchedEffect(key1 = Unit){
//        Log.i("roomIdroomId", roomId.toString())
//        Log.i("artifact", artifact)
//    }

    val stompProvider = LocalWebsocketConnector.current

    LaunchedEffect(key1 = Unit) {
        viewModel.loadRoom(roomId)
        stompProvider.newUserAddedListener(roomId)
    }

    val roomUiState by viewModel.roomUiState.collectAsState()
    val callUiState by viewModel.callUiState.collectAsState()
    val navDirection by viewModel.navDirection.collectAsState()

    val sessionManager = LocalSessionManager.current
//
//    val queue = stompProvider.messageFlow

    val users by stompProvider.userListChanges.collectAsState(initial = 0L)

    LaunchedEffect(key1 = users) {
        viewModel.getRoomInfoById(roomId)
    }

    var qr by remember {
        mutableStateOf("")
    }



    LaunchedEffect(key1 = roomUiState.myId) {
        if (roomUiState.myId != null) {
            if (artifact.isNotEmpty() && artifact != "1") {
                Log.i("artifact", artifact)
                viewModel.joinInRoom(roomId, artifact)
            } else {
                viewModel.getRoomInfoById(roomId)
                Log.i("artifactartifact", artifact)
            }

        }

    }

    LaunchedEffect(key1 = roomUiState.roomDataEntity) {
        roomUiState.roomDataEntity?.let {
            viewModel.getUsersById(roomUiState.roomDataEntity!!.users)
        }
    }

    LaunchedEffect(key1 = Unit) {
        sessionManager.onSessionScreenReady()
        stompProvider.subscribeOnTracks(roomId)
        viewModel.getGenreMusicByName("КЛАССИКА")
    }



    LaunchedEffect(key1 = roomUiState) {
        qr = roomUiState.roomDataEntity?.artifact ?: "HUI"
    }

    LaunchedEffect(key1 = navDirection) {
        when (navDirection) {
            RoomNavDirection.PopBackStack -> onClickBack()
            RoomNavDirection.Default -> {
            }
        }
    }

    val tabsList by remember {
        mutableStateOf(
            listOf(
                TabModel.ParticipantsAdvices,
                TabModel.ParticipantsQueue
            ).sortedBy { it.order }
        )
    }

    var selectedTab by remember(tabsList) {
        mutableStateOf(
            tabsList.firstOrNull()
        )
    }

    val clipboardManager = LocalClipboardManager.current

    var isDialogVisible by remember {
        mutableStateOf(false)
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
                    .padding(horizontal = 22.dp)
            ) {

                Icon(
                    painter = painterResource(id = pat.project.challengehack.R.drawable.ic_charm_arrow_up),
                    contentDescription = null,
                    tint = AppResources.colors.White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable {
                            onClickBack()
                        }
                )

                Icon(
                    painter = painterResource(id = pat.project.challengehack.R.drawable.logo),
                    contentDescription = null,
                    tint = AppResources.colors.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        },
        bottomBar = {
            RoomBottomBar(
                modifier = Modifier.fillMaxWidth(),
                navigateToChat = {
                    roomUiState.myId?.let(navigateToChat)
                },
                isMicroOn = callUiState.isMicroOn,
                toggleMicro = {
                    sessionManager.enableMicrophone(
                        callUiState.isMicroOn
                    )
                    viewModel.toggleMicro()
                },
                isVolumeOn = callUiState.isVolumeOn,
                toggleVolume = {
                    sessionManager.enableVolume(
                        callUiState.isVolumeOn
                    )
                    viewModel.toggleVolume()
                },
                onFinishAndLeave = {
                    sessionManager.disconnect()
                    onClickBack()
                },
                isOwner = roomUiState.roomDataEntity?.isOwner ?: false

            )

        }

    ) { paddingValues ->
        Box(
            modifier = modifier
                .padding(bottom = paddingValues.calculateBottomPadding())
                .background(color = AppResources.colors.Black)
        ) {
            if (isDialogVisible) {
                Dialog(
                    onDismissRequest = { isDialogVisible = false }
                ) {
                    Column(
                        modifier = Modifier
                            .background(
                                color = AppResources.colors.Grey90,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 20.dp)
                            .padding(vertical = 16.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = stringResource(id = pat.project.challengehack.R.string.add_user),
                                style = AppResources.typography.titles.title0,
                                color = AppResources.colors.White,
                                textAlign = TextAlign.Center
                            )

                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = AppResources.colors.White,
                                modifier = Modifier
                                    .clickable {
                                        isDialogVisible = !isDialogVisible
                                    }
                            )
                        }

                        Text(
                            text = stringResource(id = pat.project.challengehack.R.string.link_room),
                            style = AppResources.typography.titles.title1,
                            color = AppResources.colors.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 27.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 18.dp)
                                .background(
                                    AppResources.colors.Black,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    clipboardManager.setText(AnnotatedString("http://300notes/room/join/$roomId-${roomUiState.roomDataEntity?.artifact}"))
                                }
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = stringResource(
                                    id = R.string.link_in_room,
                                    "http://300notes/room/join/$roomId-${roomUiState.roomDataEntity?.artifact}"
                                ),
                                style = AppResources.typography.titles.title1,
                                color = AppResources.colors.White,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .weight(1f)

                            )
                            Icon(
                                imageVector = Icons.Default.CopyAll,
                                contentDescription = null,
                                tint = AppResources.colors.White,
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 25.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = stringResource(id = R.string.qr_code),
                                style = AppResources.typography.titles.title1,
                                color = AppResources.colors.White,
                                textAlign = TextAlign.Center,
                                maxLines = 1
                            )
                            Icon(
                                imageVector = Icons.Default.IosShare,
                                contentDescription = null,
                                tint = AppResources.colors.White,
                                modifier = Modifier
                            )
                        }

                        if (BarcodeType.QR_CODE.isValueValid(qr)) {
                            Barcode(
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .width(150.dp)
                                    .height(150.dp),
                                resolutionFactor = 10, // Optionally, increase the resolution of the generated image
                                type = BarcodeType.QR_CODE, // pick the type of barcode you want to render
                                value = qr // The textual representation of this code
                            )
                        }

                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(id = pat.project.challengehack.R.string.room_participants),
                        color = AppResources.colors.White
                    )
//                roomUiState.roomDataEntity?.let {
//                    Text(
//                        modifier = Modifier.padding(start = 16.dp),
//                        text = stringResource(
//                            id = R.string.room_participants,
//                            it.users.size
//                        )
//                    )
//                }
                }

                LazyRow(modifier = Modifier.padding(top = 8.dp)) {
                    item {
                        AddParticipantIcon {
                            isDialogVisible = !isDialogVisible
                        }
                    }

                    items(roomUiState.roomParticipantsFullDataEntity) { fullDescription ->
                        ParticipantImageAndName(
                            isOwner = roomUiState.roomDataEntity?.ownerId == fullDescription.userId,
                            username = fullDescription.username,
                            userPhotoUrl = fullDescription.profilePictureUrl
                        )
                    }

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    tabsList.forEach { currentTab ->
                        Text(
                            modifier = Modifier.clickable {
                                selectedTab = currentTab
                            },
                            text = stringResource(id = currentTab.tabName),
                            style = AppResources.typography.titles.title0,
                            color = if (selectedTab == currentTab) AppResources.colors.White
                            else AppResources.colors.Grey70
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxHeight()
                ) {
                    if (selectedTab == TabModel.ParticipantsAdvices) {
                        items(roomUiState.soundList) { item ->
                            OfferItem(
                                item = item,
                                modifier = Modifier,
                                addTrackToQueue = {
                                    stompProvider.addTrackToQueue(roomId, item.trackId)
                                }
                            )
                        }
                    } else {
                        items(roomUiState.soundList) { item ->
                            QueueItem(item = item, modifier = Modifier)
                        }
                    }
                }
            }
        }
    }
}
