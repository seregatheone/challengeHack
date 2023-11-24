package pat.project.challengehack.screens.friends.friendsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pat.project.conversay.screens.friends.friendsScreen.models.FriendsNavDirections
import javax.inject.Inject

@HiltViewModel
class FriendsScreenViewModel @Inject constructor(
//    private val profileInteractor: ProfileInteractor,
//    private val chatInteractor: ChatInteractor
) : ViewModel() {

//    private val _friendsNavDirections = MutableStateFlow<FriendsNavDirections>(FriendsNavDirections.Default)
//    val friendsNavDirections = _friendsNavDirections.asStateFlow()
//
//    private val _friendList = profileInteractor.getFriendPagingData()
//
//    val friendList: Flow<PagingData<FriendEntity>> =
//        _friendList.cachedIn(viewModelScope)
//
//    fun clearNavDirections(){
//        _friendsNavDirections.update {
//            FriendsNavDirections.Default
//        }
//    }
//
//    fun navigateToCall(userId : Int){
//        _friendsNavDirections.update {
//            FriendsNavDirections.Call(userId)
//        }
//    }
//
//    fun navigateToFriendsRequests(){
//        _friendsNavDirections.update {
//            FriendsNavDirections.FriendRequests
//        }
//    }
//
//
//    fun sendFriendRequest(userId: Int) {
//        viewModelScope.launch {
//            when (val response = profileInteractor.sendFriendRequest(userId)) {
//                is Entity.Success -> {
////                    _profileInfo.value = response.data
//                    // Пишем что всё збс
//                }
//
//                is Entity.Error -> {
//                    //отображение ошибок
//                }
//
//                else -> {
//
//                }
//            }
//        }
//    }
//
//    fun checkOrCreateDirectChat(username : String){
//        viewModelScope.launch {
//            when (val response = chatInteractor.createDirectChat(username)) {
//                is Entity.Success -> {
//                    _friendsNavDirections.value = FriendsNavDirections.Chat(response.data.chatId)
//                }
//
//                is Entity.Error -> {
//                    //отображение ошибок
//                }
//
//                else -> {
//
//                }
//            }
//        }
//    }

}