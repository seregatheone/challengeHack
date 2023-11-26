package pat.project.challengehack.screens.rooms.roomScreen

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import core.ui.themes.AppResources
import pat.project.challengehack.LocalSessionManager
import pat.project.challengehack.screens.rooms.roomScreen.components.AddParticipantIcon
import pat.project.challengehack.screens.rooms.roomScreen.components.ParticipantImageAndName
import pat.project.challengehack.screens.rooms.roomScreen.components.RoomBottomBar
import pat.project.challengehack.screens.rooms.roomScreen.models.TabModel



@Composable
fun RoomScreen(
    modifier: Modifier = Modifier,
    viewModel: RoomViewModel = hiltViewModel(),
    roomId: Long,
    navigateToChat: (Long) -> Unit,
    onClickBack: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadRoom(roomId)
    }

    val roomUiState by viewModel.roomUiState.collectAsState()
    val callUiState by viewModel.callUiState.collectAsState()

    val sessionManager = LocalSessionManager.current

    val Qr: Bitmap

    LaunchedEffect(key1 = Unit) {
        sessionManager.onSessionScreenReady()

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
        Box(modifier = modifier
            .padding(bottom = paddingValues.calculateBottomPadding())
            .background(color = AppResources.colors.Black)) {
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
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = stringResource(id = pat.project.challengehack.R.string.link_in_room, "https://www.youtube.com/watch?v=dQw4w9WgXcQ&pp=ygUR0LrRiNGB0Lsg0LrRidC00LQ%3D"),
                                style = AppResources.typography.titles.title1,
                                color = AppResources.colors.White,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis

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
                                text = stringResource(id = pat.project.challengehack.R.string.qr_code),
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
//                        Image(bitmap = , contentDescription = )

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
                    if (roomUiState.roomParticipantsFullDataEntity.isNotEmpty()) {
                        items(roomUiState.roomParticipantsFullDataEntity) { fullDescription ->
                            ParticipantImageAndName(
                                isOwner = roomUiState.roomDataEntity?.ownerId == fullDescription.userId,
                                username = fullDescription.username,
                                userPhotoUrl = fullDescription.profilePictureUrl
                            )
                        }
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

                LazyColumn(modifier = Modifier.padding(top = 12.dp)) {

                }
            }
        }
    }
}



fun getQrCodeBitmap(text: String): Bitmap {
    val size = 170 //pixels
    val qrCodeContent = text
    val bits = QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE, size, size)
    return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
        for (x in 0 until size) {
            for (y in 0 until size) {
                it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
            }
        }
    }
}