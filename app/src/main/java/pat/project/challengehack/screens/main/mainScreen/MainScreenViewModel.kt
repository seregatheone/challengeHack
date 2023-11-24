package pat.project.challengehack.screens.main.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pat.project.challengehack.screens.main.mainScreen.models.MainNavDirections
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
//    private val profileInteractor: ProfileInteractor,
//    private val chatInteractor : ChatInteractor
    ) : ViewModel() {
//    private val _friendList  = chatInteractor.getAllChatsByPaging()
//    private val _serverList  = profileInteractor.getServersPagingData()
//
//    val directConversationList: Flow<PagingData<ChatBasicInfoEntity>> =
//        _friendList.cachedIn(viewModelScope)
//
//    val serverList: Flow<PagingData<ServerEntity>> =
//        _serverList.cachedIn(viewModelScope)
//
//    private val _mainNavDirections = MutableStateFlow<MainNavDirections>(MainNavDirections.Default)
//    val mainNavDirections = _mainNavDirections.asStateFlow()
//
//    fun navigateToFriendList(){
//        _mainNavDirections.update {
//            MainNavDirections.FriendList
//        }
//    }
//
//    fun navigateToDirectChat(chatId : Int){
//        _mainNavDirections.update {
//            MainNavDirections.Chat(chatId)
//        }
//    }
//
//    fun navigateToServerChat(serverId : Int){
//        _mainNavDirections.update {
//            MainNavDirections.Server(serverId)
//        }
//    }
//
//    fun clearNavDirections(){
//        _mainNavDirections.update {
//            MainNavDirections.Default
//        }
//    }

}