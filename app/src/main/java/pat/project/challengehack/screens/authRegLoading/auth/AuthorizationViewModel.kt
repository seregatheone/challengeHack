package pat.project.challengehack.screens.authRegLoading.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.auth.interactors.AuthInteractor
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.authRegLoading.auth.models.AuthorizationNavDestinations
import pat.project.challengehack.screens.authRegLoading.auth.models.AuthorizationUiState
import pat.project.challengehack.screens.authRegLoading.auth.models.containsEmptyField
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authInteractor : AuthInteractor
) : ViewModel() {
    private val _authorizationUiState = MutableStateFlow(AuthorizationUiState())
    val authorizationUiState = _authorizationUiState.asStateFlow()

    private val _authorizationNavDestinations : MutableStateFlow<AuthorizationNavDestinations> = MutableStateFlow(
        AuthorizationNavDestinations.DEFAULT)
    val authorizationNavDestinations = _authorizationNavDestinations.asStateFlow()

    fun changePassword(newPassword: String) {
        _authorizationUiState.value = authorizationUiState.value.copy(
            loginEntity = authorizationUiState.value.loginEntity.copy(
                password = newPassword
            )
        )
    }

    fun changeUsername(newUsername: String) {
        _authorizationUiState.value = authorizationUiState.value.copy(
            loginEntity = authorizationUiState.value.loginEntity.copy(
                username = newUsername
            )
        )
    }

    fun login() {
        viewModelScope.launch {
            if (!authorizationUiState.value.containsEmptyField()) {
                when (authInteractor.login(
                    authorizationUiState.value.loginEntity
                )){
                    is Entity.Success -> {
                        _authorizationNavDestinations.value = AuthorizationNavDestinations.MAIN
                    }
                    is Entity.Error -> {

                    }
                }
            }

        }
    }

}