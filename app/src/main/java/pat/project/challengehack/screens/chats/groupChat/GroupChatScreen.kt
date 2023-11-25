package pat.project.challengehack.screens.chats.groupChat

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import core.ui.themes.AppResources
import pat.project.challengehack.LocalWebsocketConnector
import pat.project.challengehack.screens.chats.chatBasics.ChatScaffold


@Composable
fun GroupChatScreen(
    modifier: Modifier = Modifier,
    myId: Long,
    roomId: Long,
    viewModel: GroupChatViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()
    val messageFromSocket by viewModel.messageFromSocketLocal.collectAsState()

    val websocketStompDataConnector = LocalWebsocketConnector.current


    BackHandler {
        websocketStompDataConnector.disconnectFromChat()
        onBackPressed()
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getRoomInfoById(roomId)
        viewModel.setWebsocketConnector(
            websocketStompDataConnector,
            roomId
        )
    }


    CompositionLocalProvider(LocalMyIdProvider provides myId) {
        ChatScaffold(
            modifier = modifier,
            onBackPressed = {
                websocketStompDataConnector.disconnectFromChat()
                onBackPressed()
            },
            messagesPagingList = uiState.chatMessages,
            messagesFromSocket = messageFromSocket,
            sendMessage = { message ->
                viewModel.sendMessageThroughSocket(message)
            }
        )
    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        CircularProgressIndicator(
//            modifier = Modifier
//                .width(82.dp)
//                .align(Alignment.Center),
//            color = AppResources.colors.YellowGold,
//            strokeWidth = 6.dp
//        )
//    }

}

val LocalMyIdProvider = compositionLocalOf<Long> { error("No WebsocketService found!") }