package pat.project.challengehack.screens.chats.groupChat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import basic.domain.room.interactors.RoomInteractor
import basic.domain.room.models.ChatMessageEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import impl.data.providers.WebsocketStompDataConnector
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.chats.chatBasics.models.WebsocketMessageUI
import utils.time.toLocalDatetime
import utils.time.toSendMessagesDto
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class GroupChatViewModel @Inject constructor(
    private val roomInteractor: RoomInteractor,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState = _uiState.asStateFlow()

    private val _stompWebsocketProvider: MutableStateFlow<WebsocketStompDataConnector?> =
        MutableStateFlow(null)
    private val stompWebsocketProvider = _stompWebsocketProvider.asStateFlow()

    private val _messageFromSocketLocal = MutableStateFlow(emptyList<WebsocketMessageUI>())
    val messageFromSocketLocal = _messageFromSocketLocal.asStateFlow()

    init {
        viewModelScope.launch {
            stompWebsocketProvider.collectLatest { stompWebsocketProvider ->
                stompWebsocketProvider?.let {
                    it.messageFlow.collect { message ->
                        uiState.value.myId?.let { myId ->
                            _messageFromSocketLocal.update { messageFromSocketLocalOld ->
                                messageFromSocketLocalOld + WebsocketMessageUI(
                                    messageTime = message.sendTime.toLocalDatetime(),
                                    messageIsMine = message.senderId == myId,
                                    messageText = message.text,
                                    messagePhoto = message.senderUrl
                                )
                            }
                        }

                    }
                }
            }
        }
    }

    fun setRoomId(roomId: Long) {
        _uiState.update {
            it.copy(
                roomId = roomId
            )
        }
    }

    fun setMineId(mineId: Long) {
        _uiState.update {
            it.copy(
                myId = mineId
            )
        }
    }

    fun setWebsocketConnector(
        websocketStompDataConnector: WebsocketStompDataConnector,
        roomId: Long
    ) {
        _stompWebsocketProvider.update {
            websocketStompDataConnector
        }
        websocketStompDataConnector.connectToChatToListening(roomId)
    }


    fun sendMessageThroughSocket(message: String) {
        stompWebsocketProvider.value?.let { stomp ->
            uiState.value.roomId?.let { roomId ->
                stomp.sendMessageInChat(
                    roomId,
                    message = WebsocketMessageSendEntity(
                        content = message,
                        sendTimestamp = LocalDateTime.now().toSendMessagesDto(),
                    )
                )
            }

        }
//        _messageFromSocketLocal.update {
//            val prevList = messageFromSocketLocal.value.toMutableList()
//            prevList.add(
//                WebsocketMessageUI(
//                    messageTime = LocalDateTime.now().plusHours(3),
//                    messageIsMine = true,
//                    messageText = message
//                )
//            )
//            prevList.toList()
//        }
    }
}