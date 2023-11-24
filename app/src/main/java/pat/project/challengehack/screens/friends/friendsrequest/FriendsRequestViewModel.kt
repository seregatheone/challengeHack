package pat.project.challengehack.screens.friends.friendsrequest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendsRequestViewModel @Inject constructor(
//    private val profileInteractor: ProfileInteractor
): ViewModel() {
//    private val _friendOffersList  = profileInteractor.getFriendOffersPagingData()
//
//    val friendOffersList: Flow<PagingData<FriendRequestEntity>> =
//        _friendOffersList.cachedIn(viewModelScope)
//
//    fun acceptFriendRequest(userId : Int){
//        viewModelScope.launch {
//            when (val response = profileInteractor.acceptFriendRequest(userId)) {
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
//    fun rejectFriendRequest(userId : Int){
//        viewModelScope.launch {
//            when (val response = profileInteractor.rejectFriendRequest(userId)) {
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

}