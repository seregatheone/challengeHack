package pat.project.challengehack.screens.authRegLoading.auth.models

import basic.domain.auth.models.login.LoginEntity

data class AuthorizationUiState(
    val loginEntity: LoginEntity = LoginEntity(
        username = "",
        password = "",
    )
)

fun AuthorizationUiState.containsEmptyField(): Boolean {
    return listOf(
        loginEntity.password,
        loginEntity.username
    ).any { it.isEmpty() }
}