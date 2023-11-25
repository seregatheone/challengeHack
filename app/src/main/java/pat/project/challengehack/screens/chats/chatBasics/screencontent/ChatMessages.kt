package pat.project.challengehack.screens.chats.chatBasics.screencontent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import basic.domain.room.models.ChatMessageEntity
import core.ui.themes.AppResources
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.chats.chatBasics.datespacer.DateSpacerConditions
import pat.project.challengehack.screens.chats.chatBasics.message.ChatMessage
import pat.project.challengehack.screens.chats.chatBasics.message.DrawChatMessage
import pat.project.challengehack.screens.chats.chatBasics.models.WebsocketMessageUI
import pat.project.challengehack.screens.chats.groupChat.LocalMyIdProvider
import utils.time.toLocalDatetime

@Composable
fun ChatMessages(
    modifier: Modifier = Modifier,
    messagesPagingList: List<ChatMessageEntity>,
    messagesFromSocket: List<WebsocketMessageUI>
) {

    val listState = rememberLazyListState()

    val showIcon by remember(listState.isScrollInProgress) {
        mutableStateOf(
            !listState.isScrolledToTheEnd() && listState.layoutInfo.totalItemsCount != 0
        )
    }

    val myId = LocalMyIdProvider.current
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = modifier) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState
        ) {
            messagesPagingList.forEachIndexed { index, currentMessage ->
                item {
                    DateSpacerConditions(
                        prevDate = messagesPagingList.getOrNull(index - 1)?.sendTimestamp?.toLocalDatetime(),
                        currentDate = currentMessage.sendTimestamp.toLocalDatetime()
                    )
                }
                item {
                    Column(modifier = Modifier.fillMaxWidth()) {

                        when (currentMessage.senderId == myId) {
                            true -> {
                                DrawChatMessage(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    chatMessage = ChatMessage.MyMessage(
                                        messageDate = currentMessage.sendTimestamp.toLocalDatetime(),
                                        messageBody = currentMessage.content,
                                        photoUrl = ""
                                    ),
                                )
                            }

                            false -> {
                                DrawChatMessage(
                                    modifier = Modifier
                                        .align(Alignment.Start),
                                    chatMessage = ChatMessage.InterlocutorMessage(
                                        messageDate = currentMessage.sendTimestamp.toLocalDatetime(),
                                        messageBody = currentMessage.content,
                                        ""
                                    ),
                                )
                            }
                        }


                    }
                }
            }
            messagesFromSocket.forEachIndexed { index, currentMessage ->
                item {
                    DateSpacerConditions(
                        prevDate =
                        if (index == 0) {
                            messagesPagingList.lastOrNull()?.sendTimestamp?.toLocalDatetime()
                        } else {
                            messagesFromSocket.getOrNull(index - 1)?.messageTime
                        },
                        currentDate = currentMessage.messageTime
                    )
                }
                item {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        when (currentMessage.messageIsMine) {

                            true -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {

                                    DrawChatMessage(
                                        modifier = Modifier
                                            .align(Alignment.End),
                                        chatMessage = ChatMessage.MyMessage(
                                            messageDate = currentMessage.messageTime,
                                            messageBody = currentMessage.messageText,
                                            photoUrl = ""
                                        ),
                                    )

                                }

                            }

                            false -> {
                                Column(
                                    modifier = Modifier.fillMaxWidth()
                                ) {

                                    DrawChatMessage(
                                        modifier = Modifier
                                            .align(Alignment.Start),
                                        chatMessage = ChatMessage.InterlocutorMessage(
                                            messageDate = currentMessage.messageTime,
                                            messageBody = currentMessage.messageText,
                                            photoUrl = ""
                                        ),
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }

        if (showIcon) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 12.dp)
                    .background(color = AppResources.colors.White, CircleShape),
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(listState.layoutInfo.totalItemsCount - 1)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    tint = AppResources.colors.Grey,
                    contentDescription = null
                )

            }
        }
    }

}

fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1