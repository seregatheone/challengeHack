package impl.domain.interactors

import basic.data.repositories.AuthRepository
import basic.domain.auth.interactors.AuthInteractor
import basic.domain.auth.models.login.LoginEntity
import basic.domain.auth.models.registration.RegistrationEntity
import common.domain.entity.Entity


class AuthInteractorImpl(
    private val authRepository: AuthRepository
) : AuthInteractor {
    override suspend fun verifyAccess(): Entity<Unit> {
        return authRepository.verifyAccess()
    }

    override suspend fun registration(registrationEntity: RegistrationEntity): Entity<Unit> {
        return authRepository.registration(registrationEntity)
    }

    override suspend fun login(loginEntity: LoginEntity): Entity<Unit> {
        return authRepository.login(
            loginEntity = loginEntity
        )
    }

    override suspend fun logout(): Entity<Unit> {
        return authRepository.logout()
    }

    override suspend fun logoutAllSessions(): Entity<Unit> {
        return authRepository.logoutAllSessions()
    }
}