package pat.project.challengehack.screens.profile.passwordChanges

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pat.project.challengehack.screens.profile.passwordChanges.models.PasswordUiState
import utils.validators.PasswordValidator
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor(
//    profileInteractor: ProfileInteractor
): ViewModel(){
//    private val _passUiState = MutableStateFlow(PasswordUiState())
//    val passUiState = _passUiState.asStateFlow()
//
//    private val passValid = PasswordValidator()
//
//    fun changeOldPass(newPass: String) {
//        _passUiState.value = passUiState.value.copy(
//            oldPassword = newPass
//        )
//    }
//
//    fun changeNewPass(newPass: String) {
//        _passUiState.value = passUiState.value.copy(
//            newPassword = newPass,
//            isNewPassValid = passValid.validate(newPass)
//        )
//    }
//
//    fun changeRepPass(newPass: String) {
//        _passUiState.value = passUiState.value.copy(
//            repPassword = newPass
//        )
//    }
//
//    fun updatePassword(){
//
//    }
}