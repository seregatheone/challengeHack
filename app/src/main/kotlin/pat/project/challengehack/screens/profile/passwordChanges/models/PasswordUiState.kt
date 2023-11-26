package pat.project.challengehack.screens.profile.passwordChanges.models

data class PasswordUiState(
    val oldPassword: String = "",
    val newPassword: String = "",
    val repPassword: String = "",
    val isNewPassValid: Boolean = true,
)