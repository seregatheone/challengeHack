package impl.data.repositories

import backend.utils.models.ResponseStatus
import basic.data.repositories.AuthRepository
import basic.domain.auth.models.login.LoginEntity
import basic.domain.auth.models.registration.RegistrationEntity
import challengeHack.api.AuthApi
import common.domain.entity.Entity
import impl.data.base.BaseRepository
import impl.data.mappers.asDto
import impl.data.store.AuthorizationStore

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val authorizationStore: AuthorizationStore
) : AuthRepository, BaseRepository(AuthRepositoryImpl::class.toString()) {
    override suspend fun verifyAccess(): Entity<Unit> {
        return when (val response = safeApiSuspendResult {
            authApi.verifyAccess()
        }) {
            is ResponseStatus.Success -> {
                map { Unit }
            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }

    }

    override suspend fun registration(registrationEntity: RegistrationEntity): Entity<Unit> {
        return when (val response = safeApiSuspendResult {
            authApi.registration(registrationEntity.asDto())
        }) {
            is ResponseStatus.Success -> {
                val access = response.data?.accessToken ?: ""
                val refresh = response.data?.refreshToken ?: ""
                if (access.isNotEmpty() && refresh.isNotEmpty()) {
                    authorizationStore.accessToken = access
                    authorizationStore.refreshToken = refresh
                    map {
                        Unit
                    }
                } else {
                    Entity.Error(
                        "AuthRepositoryImpl registration tokens are blank"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }

    override suspend fun login(
        loginEntity: LoginEntity
    ): Entity<Unit> {
        return when (val response = safeApiSuspendResult {
            authApi.login(loginEntity.asDto())
        }) {
            is ResponseStatus.Success -> {
                val access = response.data?.accessToken ?: ""
                val refresh = response.data?.refreshToken ?: ""
                if (access.isNotEmpty() && refresh.isNotEmpty()) {
                    authorizationStore.accessToken = access
                    authorizationStore.refreshToken = refresh
                    map {
                        Unit
                    }
                } else {
                    Entity.Error(
                        "AuthRepositoryImpl login tokens are blank"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }

    override suspend fun logout(): Entity<Unit> {
        return when (val response = safeApiSuspendResult {
            authApi.logout()
        }) {
            is ResponseStatus.Success -> {
                authorizationStore.clearTokens()
                map { Unit }
            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }

    override suspend fun logoutAllSessions(): Entity<Unit> {
        return when (val response = safeApiSuspendResult {
            authApi.logoutAllSessions()
        }) {
            is ResponseStatus.Success -> {
                authorizationStore.clearTokens()
                map { Unit }
            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }
}