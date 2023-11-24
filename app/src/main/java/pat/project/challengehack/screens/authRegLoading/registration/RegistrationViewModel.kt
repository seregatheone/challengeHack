package pat.project.challengehack.screens.authRegLoading.registration

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
//    private val authInteractor: AuthInteractor
) : ViewModel() {

//    private val _registrationUiState = MutableStateFlow(RegistrationUiState())
//    val registrationUiState = _registrationUiState.asStateFlow()
//
//    private val _registrationNavDestination : MutableStateFlow<RegistrationNavDestinations> = MutableStateFlow(
//        RegistrationNavDestinations.DEFAULT)
//    val registrationNavDestination = _registrationNavDestination.asStateFlow()
//
//    private val passValid = PasswordValidator()
//    private val emailValid = EmailValidator()
//
//    fun changeEmail(newEmail: String) {
//        _registrationUiState.value = registrationUiState.value.copy(
//            registrationEntity = registrationUiState.value.registrationEntity.copy(
//                email = newEmail,
//
//
//            ),
//            isEmailValid = emailValid.validate(newEmail)
//        )
//    }
//
//    fun changePassword(newPassword: String) {
//        _registrationUiState.value = registrationUiState.value.copy(
//            registrationEntity = registrationUiState.value.registrationEntity.copy(
//                password = newPassword
//            ),
//            isPasswordValid = passValid.validate(newPassword)
//        )
//    }
//
//    fun changeUsername(newUsername: String) {
//        _registrationUiState.value = registrationUiState.value.copy(
//            registrationEntity = registrationUiState.value.registrationEntity.copy(
//                username = newUsername
//            )
//        )
//    }
//
//
//    fun changeGender(newGender: GenderEntityRegistration) {
//        _registrationUiState.value = registrationUiState.value.copy(
//            registrationEntity = registrationUiState.value.registrationEntity.copy(
//                gender = newGender
//            )
//        )
//    }
//
//    fun registerUser() {
//        viewModelScope.launch {
//            if (!registrationUiState.value.containsEmptyField()) {
//                when (authInteractor.registration(
//                    registrationUiState.value.registrationEntity
//                )){
//                    is Entity.Success -> {
//                        _registrationNavDestination.value = RegistrationNavDestinations.MAIN
//                    }
//                    is Entity.Error -> {
//
//                    }
//                }
//            }
//
//        }
//    }

}