package impl.data.providers

import impl.data.managers.WebRtcSessionManager
interface WebRtcDataConnector {
    val sessionManager : WebRtcSessionManager
    fun connectToWebRtc(roomId : Long)
    fun disconnectWebRtc()
}