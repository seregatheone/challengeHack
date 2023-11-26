package pat.project.challengehack.screens.container

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ContainerViewModel @Inject constructor(
//    private val profileInteractor: ProfileInteractor
) : ViewModel() {
    private val _profileImage = MutableStateFlow("")
    val profileImage = _profileImage.asStateFlow()


//    init {
//        viewModelScope.launch {
//            when (val response = profileInteractor.getProfileInfo()) {
//                is Entity.Success -> {
//                    _profileImage.value = response.data.profilePictureUrl
//                }
//
//                is Entity.Error -> {
//
//                }
//            }
//        }
//
//        viewModelScope.launch {
//            profileInteractor.photoFlow.collectLatest {
//                _profileImage.update { it }
//            }
//        }
//
//    }
}