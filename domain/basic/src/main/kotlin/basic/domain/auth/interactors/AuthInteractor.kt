package basic.domain.auth.interactors

import basic.domain.auth.models.login.LoginEntity
import basic.domain.auth.models.registration.RegistrationEntity
import common.domain.entity.Entity

interface AuthInteractor {
    suspend fun verifyAccess() : Entity<Unit>

    suspend fun registration(
        registrationEntity : RegistrationEntity
    ) : Entity<Unit>

    suspend fun login(
        loginEntity : LoginEntity
    ) : Entity<Unit>

    suspend fun logout() : Entity<Unit>
    suspend fun logoutAllSessions() : Entity<Unit>
}