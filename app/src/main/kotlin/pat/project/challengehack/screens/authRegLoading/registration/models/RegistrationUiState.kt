package pat.project.challengehack.screens.authRegLoading.registration.models

import basic.domain.auth.models.registration.GenderEntityRegistration
import basic.domain.auth.models.registration.RegistrationEntity


data class RegistrationUiState(
    val registrationEntity: RegistrationEntity = RegistrationEntity(
        username = "",
        password = "",
        email = "",
        gender = GenderEntityRegistration.MALE,
    ),
    val isEmailValid: Boolean = true,
    val isPasswordValid: Boolean = true,
)

fun RegistrationUiState.containsEmptyField(): Boolean {
    return listOf(
        registrationEntity.email,
        registrationEntity.password,
        registrationEntity.username
    ).any { it.isEmpty() }
}