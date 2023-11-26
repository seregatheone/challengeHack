package pat.project.challengehack.screens.rooms.roomScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.profile.interactors.ProfileInteractor
import basic.domain.room.interactors.RoomInteractor
import basic.domain.room.models.RoomAllInfoEntity
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.rooms.roomScreen.models.CallUiState
import pat.project.challengehack.screens.rooms.roomScreen.models.RoomNavDirection
import pat.project.challengehack.screens.rooms.roomScreen.models.RoomUiState
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val roomInteractor: RoomInteractor,
    private val profileInteractor: ProfileInteractor
) : ViewModel() {

    private val _roomUiState = MutableStateFlow(RoomUiState())
    val roomUiState = _roomUiState.asStateFlow()

    private val _callUiState = MutableStateFlow(CallUiState())
    val callUiState = _callUiState.asStateFlow()

    private val _navDirection = MutableStateFlow<RoomNavDirection>(RoomNavDirection.Default)
    val navDirection = _navDirection.asStateFlow()


    fun joinInRoom(roomId: Long, artifact: String) {
        viewModelScope.launch {
            when (val response = roomInteractor.joinInRoom(roomId, artifact)) {
                is Entity.Success -> {
                    _roomUiState.update { roomUiState ->
                        roomUiState.copy(
                            roomDataEntity = RoomAllInfoEntity(
                                response.data.ownerId,
                                response.data.tracks,
                                response.data.messages,
                                response.data.users,
                                response.data.isOwner,
                                response.data.offers,
                                response.data.artifact,
                            ),
                        )
                    }
                }

                is Entity.Error -> {

                }

                else -> {

                }
            }
        }
    }

    fun createRoom() {
        viewModelScope.launch {
            when (val response = roomInteractor.createRoom()) {
                is Entity.Success -> {
                    _roomUiState.update { roomUiState ->
                        roomUiState.copy(
                            roomDataEntity = RoomAllInfoEntity(
                                response.data.ownerId,
                                response.data.tracks,
                                response.data.messages,
                                response.data.users,
                                response.data.isOwner,
                                response.data.offers,
                                response.data.artifact,
                            ),
                        )
                    }
                }

                is Entity.Error -> {

                }

                else -> {

                }
            }
        }
    }

    init {
        viewModelScope.launch {
            when (val result = profileInteractor.getMineProfile()) {
                is Entity.Success -> {
                    _roomUiState.update {
                        it.copy(
                            myId = result.data.userId
                        )
                    }
                }

                is Entity.Error -> {

                }
            }
        }

    }

    fun toggleMicro() {
        _callUiState.update {
            it.copy(
                isMicroOn = !callUiState.value.isMicroOn
            )
        }
    }

    fun toggleVolume() {
        _callUiState.update {
            it.copy(
                isVolumeOn = !callUiState.value.isVolumeOn
            )
        }
    }

    fun loadRoom(roomId: Long) {

    }

}