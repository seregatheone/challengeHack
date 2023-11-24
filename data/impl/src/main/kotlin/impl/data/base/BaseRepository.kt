package impl.data.base


import backend.utils.exceptions.AuthException
import backend.utils.exceptions.NetworkException
import backend.utils.exceptions.NoNetworkException
import backend.utils.models.ResponseStatus
import common.domain.entity.Entity
import impl.data.base.ResponseCodes.AUTHENTICATION_ERROR_CODE
import impl.data.base.ResponseCodes.SERVER_ERROR_CODE
import impl.data.base.ResponseCodes.SUCCESS_CODES
import impl.data.errorbroadcast.ErrorStatus
import impl.data.errorbroadcast.LocalBroadcastManager
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException

open class BaseRepository(
    private val repository: String = TAG,
) {

    protected suspend fun <K : Any> safeApiSuspendResult(call: suspend () -> Response<K>?): ResponseStatus<K> {
        val response: Response<K>?
        return try {
            response = call.invoke()
            when (response?.code()) {
                in SUCCESS_CODES -> {
                    if (response?.isSuccessful == true) {
                        ResponseStatus.Success(
                            data = response.body(),
                            code = response.code()
                        )
                    } else {
                        ResponseStatus.Error(
                            exception = NetworkException(
                                message = response?.message(),
                                cause = Throwable(repository)
                            )
                        )
                    }

                }

                in SERVER_ERROR_CODE -> {
                    LocalBroadcastManager._error.emit(
                        ErrorStatus.Network(
                            response?.message() ?: ""
                        )
                    )
                    ResponseStatus.Error(
                        NetworkException(
                            response?.message(),
                            Throwable(repository),
                        )
                    )
                }

                AUTHENTICATION_ERROR_CODE -> {
                    LocalBroadcastManager._error.emit(
                        ErrorStatus.Authentication(
                            if (response.message()
                                    .isNullOrEmpty()
                            ) "Попробуйте перезайти в приложение"
                            else response.message()
                        )
                    )
                    ResponseStatus.Error(
                        AuthException(
                            response.message(),
                            Throwable(repository),
                        )
                    )
                }

                else -> {
                    LocalBroadcastManager._error.emit(
                        ErrorStatus.Network(
                            response?.message() ?: ""
                        )
                    )
                    ResponseStatus.Error(
                        NetworkException(
                            response?.message(),
                            Throwable(repository),
                        )
                    )
                }
            }
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException -> {
                    LocalBroadcastManager._error.emit(ErrorStatus.Network(e.message ?: ""))
                    ResponseStatus.Error(
                        NoNetworkException(
                            e.message,
                            Throwable(repository),
                        )
                    )
                }

                is HttpException -> {
                    LocalBroadcastManager._error.emit(ErrorStatus.Network(e.message ?: ""))
                    if (e.code() == 401) {
                        ResponseStatus.Error(
                            AuthException(
                                "Время сессии истекло",
                                Throwable(repository),
                            )
                        )
                    } else {
                        LocalBroadcastManager._error.emit(ErrorStatus.Network(e.message ?: ""))
                        ResponseStatus.Error(
                            NetworkException(
                                e.message,
                                Throwable(repository),
                            )
                        )
                    }

                }

                else -> {
                    LocalBroadcastManager._error.emit(ErrorStatus.Network(e.message ?: ""))
                    ResponseStatus.Error(
                        NetworkException(
                            e.message,
                            Throwable(repository),
                        )
                    )
                }
            }
        }
    }

    protected fun <G : Any> map(call: () -> G): Entity<G> {
        return try {
            Entity.Success(
                call.invoke()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Entity.Error("Произошла ошибка")
        }
    }


    companion object {
        private const val TAG = "Repository"
    }
}
