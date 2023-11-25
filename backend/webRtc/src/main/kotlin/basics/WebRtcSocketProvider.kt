package basics

import basic.domain.webrtc.SignalingCommand
import basic.domain.webrtc.WebRTCSessionState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface WebRtcSocketProvider {
    val sessionStateFlow: StateFlow<WebRTCSessionState>
    val signalingCommandFlow: SharedFlow<Pair<SignalingCommand, String>>

    fun connectWebRtc(roomId: Long)
    fun sendCommand(signalingCommand: SignalingCommand, message: String)
    fun disconnectWebRtc()
    fun dispose()
}