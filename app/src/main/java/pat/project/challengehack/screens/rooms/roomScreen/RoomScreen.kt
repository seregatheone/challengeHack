package pat.project.challengehack.screens.rooms.roomScreen

import android.util.Log
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
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import core.ui.themes.AppResources
import pat.project.challengehack.LocalSessionManager
import pat.project.challengehack.R
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
                    painter = painterResource(id = R.drawable.ic_charm_arrow_up),
                    contentDescription = null,
                    tint = AppResources.colors.White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable {
                            onClickBack()
                        }
                )

                Icon(
                    painter = painterResource(id = R.drawable.logo),
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
            )

        }

    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .background(color = AppResources.colors.Black)
                .padding(horizontal = 24.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.room_participants),
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