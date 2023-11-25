package pat.project.challengehack.screens.rooms.roomsScreenStart

import androidx.lifecycle.ViewModel
import basic.domain.room.interactors.RoomInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pat.project.challengehack.screens.rooms.roomsScreenStart.models.RoomsUiState
import javax.inject.Inject

@HiltViewModel
class RoomsStartScreenViewModel @Inject constructor(
    private val roomInteractor: RoomInteractor
) : ViewModel() {
    private val _roomUiState = MutableStateFlow(RoomsUiState())
    val roomUiState = _roomUiState.asStateFlow()

    init {
//        _roomUiState.update {
//            it.copy(
//                invitationList = invitations
//            )
//
//        }
    }

    fun createRoom() {

    }

    fun acceptInvitation() {

    }

    fun declineInvitation() {

    }

}