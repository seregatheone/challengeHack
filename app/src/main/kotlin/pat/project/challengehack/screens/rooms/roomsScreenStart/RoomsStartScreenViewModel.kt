package pat.project.challengehack.screens.rooms.roomsScreenStart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.room.interactors.RoomInteractor
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.rooms.roomsScreenStart.models.RoomsNavDirections
import pat.project.challengehack.screens.rooms.roomsScreenStart.models.RoomsUiState
import javax.inject.Inject

@HiltViewModel
class RoomsStartScreenViewModel @Inject constructor(
    private val roomInteractor: RoomInteractor
) : ViewModel() {
    private val _roomUiState = MutableStateFlow(RoomsUiState())
    val roomUiState = _roomUiState.asStateFlow()

    private val _roomsNavDirections = MutableStateFlow<RoomsNavDirections>(RoomsNavDirections.Default)
    val roomsNavDirections = _roomsNavDirections.asStateFlow()

    init {
//        _roomUiState.update {
//            it.copy(
//                invitationList = invitations
//            )
//
//        }
    }

    fun createRoom() {
        viewModelScope.launch {
            when(val response = roomInteractor.createRoom()){
                is Entity.Success -> {
                    _roomsNavDirections.update {
                        RoomsNavDirections.RoomScreen(response.data.ownerId)
                    }
                }
                is Entity.Error -> {

                }
            }
        }

    }

    fun acceptInvitation() {

    }

    fun declineInvitation() {

    }

}