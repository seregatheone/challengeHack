package pat.project.challengehack.screens.profile.profileScreen

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.auth.interactors.AuthInteractor
import basic.domain.profile.interactors.ProfileInteractor
import basic.domain.profile.models.MyProfileDataEntity
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pat.project.conversay.screens.profile.profileScreen.models.ProfileNavDestinations
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val profileInteractor: ProfileInteractor,
    private val authInteractor: AuthInteractor
) : ViewModel() {
    private val _profileInfo = MutableStateFlow<MyProfileDataEntity?>(null)
    val profileInfo = _profileInfo.asStateFlow()

    private val _profileNavDestinations: MutableStateFlow<ProfileNavDestinations> =
        MutableStateFlow(
            ProfileNavDestinations.DEFAULT
        )
    val profileNavDestinations = _profileNavDestinations.asStateFlow()

    init {
        viewModelScope.launch {
            when (val response = profileInteractor.getMineProfile()) {
                is Entity.Success -> {
                    _profileInfo.value = response.data
                }

                is Entity.Error -> {

                }

                else -> {

                }
            }
        }
    }


    fun logout() {
        viewModelScope.launch {
            when (authInteractor.logout()) {
                is Entity.Success -> {
                    _profileNavDestinations.value = ProfileNavDestinations.WELCOME_PAGE
                }

                is Entity.Error -> {

                }

                else -> {

                }
            }
        }
    }
}