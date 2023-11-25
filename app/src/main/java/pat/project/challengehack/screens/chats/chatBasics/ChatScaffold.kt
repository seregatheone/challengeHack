package pat.project.challengehack.screens.chats.chatBasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import basic.domain.room.models.ChatMessageEntity
import core.ui.themes.AppResources
import pat.project.challengehack.screens.chats.chatBasics.screencontent.ChatMessages
import pat.project.challengehack.screens.chats.chatBasics.bottomBar.ChatBottomBar
import pat.project.challengehack.screens.chats.chatBasics.models.WebsocketMessageUI
import pat.project.challengehack.screens.chats.chatBasics.topappbar.MessengerTopAppBar
import pat.project.conversay.screens.sharedScreens.chatBasics.ChatScreenStates

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChatScaffold(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    messagesPagingList: List<ChatMessageEntity>,
    messagesFromSocket: List<WebsocketMessageUI>,
    sendMessage: (String) -> Unit,
) {

    Scaffold(
        modifier = modifier
            .statusBarsPadding()
            .background(AppResources.colors.Black)
            .fillMaxSize(),
        topBar = {
            MessengerTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                onBackPressed = onBackPressed,
            )
        }

    )
    { paddingValues ->
        Column(
            modifier = modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                )
                .imePadding()
                .background(AppResources.colors.Black)
        ) {
            ChatMessages(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                    ),
                messagesPagingList = messagesPagingList,
                messagesFromSocket = messagesFromSocket,

                )


            ChatBottomBar(
                modifier = Modifier.fillMaxWidth(),
                sendMessage = sendMessage
            )
        }

    }

}

