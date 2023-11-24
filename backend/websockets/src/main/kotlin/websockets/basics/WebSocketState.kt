package websockets.basics

sealed class WebSocketState {
    object Init : WebSocketState()
    object Connected : WebSocketState()
    object Closed : WebSocketState()

    class Message(
        val text: String,
        val sendTime: String,
        val senderId : Long
    ) : WebSocketState()

    object ErrorClosedSocket : WebSocketState()
    data class Error(private val t: Throwable? = null) : WebSocketState()

}

enum class EventWebSocket(
    val client: String = "",
    val server: String = "",
) {
    CONNECT(),
    CONNECTED(
        server = "server:connected"
    ),
    ERROR(
        server = "server:error"
    ),
}
