package impl.data.managers

import basics.WebRtcSocketProvider
import impl.data.webRtc.StreamPeerConnectionFactory
import kotlinx.coroutines.flow.SharedFlow
import org.webrtc.VideoTrack

interface WebRtcSessionManager {

    val signalingClient: WebRtcSocketProvider

    val peerConnectionFactory: StreamPeerConnectionFactory

//    val localVideoTrackFlow: SharedFlow<VideoTrack>

//    val remoteVideoTrackFlow: SharedFlow<VideoTrack>
    fun onSessionScreenReady()

//    fun flipCamera()

    fun enableMicrophone(enabled: Boolean)

    fun enableVolume(enabled: Boolean)

//    fun enableCamera(enabled: Boolean)

    fun disconnect()
}