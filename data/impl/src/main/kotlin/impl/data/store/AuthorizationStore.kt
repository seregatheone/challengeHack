package impl.data.store

import android.content.Context

class AuthorizationStore(private val context: Context) {
    private val sp = context.getSharedPreferences(AUTH_STORE, Context.MODE_PRIVATE)
    var accessToken: String
        get() {
            return sp.getString(
                ACCESS_TOKEN_KEY,
                ""
            ) ?: ""
        }
        set(value) {
            sp.edit().apply {
                putString(ACCESS_TOKEN_KEY, value)
                apply()
            }
        }

    var refreshToken: String
        get() {
            return sp.getString(
                REFRESH_TOKEN_KEY,
                ""
            ) ?: ""
        }
        set(value) {
            sp.edit().apply {
                putString(REFRESH_TOKEN_KEY, value)
                apply()
            }
        }

    fun clearTokens() {
        accessToken = ""
        refreshToken = ""
    }

    companion object {
        private const val AUTH_STORE = "AUTH_STORE"
        private const val ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY"
        private const val REFRESH_TOKEN_KEY = "REFRESH_TOKEN_KEY"
    }
}
