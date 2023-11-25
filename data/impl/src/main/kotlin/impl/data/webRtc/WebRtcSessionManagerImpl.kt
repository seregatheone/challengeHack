package impl.data.webRtc

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CameraMetadata
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.Build
import androidx.core.content.getSystemService
import basic.data.webRtc.AudioHandler
import basic.domain.webrtc.SignalingCommand
import basic.domain.webrtc.StreamPeerType
import basics.WebRtcSocketProvider
import impl.data.managers.WebRtcSessionManager
import impl.data.webRtc.utils.stringify
import io.getstream.log.taggedLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import org.webrtc.AudioTrack
import org.webrtc.Camera2Capturer
import org.webrtc.Camera2Enumerator
import org.webrtc.CameraEnumerationAndroid
import org.webrtc.IceCandidate
import org.webrtc.MediaConstraints
import org.webrtc.MediaStreamTrack
import org.webrtc.RtpTransceiver
import org.webrtc.SessionDescription
import org.webrtc.SurfaceTextureHelper
import org.webrtc.VideoCapturer
import org.webrtc.VideoTrack
import java.util.UUID

private const val ICE_SEPARATOR = '$'

class WebRtcSessionManagerImpl(
    private val context: Context,
    private val audioHandler: AudioHandler,
    override val signalingClient: WebRtcSocketProvider,
    override val peerConnectionFactory: StreamPeerConnectionFactory,
) : WebRtcSessionManager {
    private val logger by taggedLogger("Call:LocalWebRtcSessionManager")

    private val sessionManagerScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    // used to send local video track to the fragment
//    private val _localVideoTrackFlow = MutableSharedFlow<VideoTrack>()
//    override val localVideoTrackFlow: SharedFlow<VideoTrack> = _localVideoTrackFlow

    // used to send remote video track to the sender
//    private val _remoteVideoTrackFlow = MutableSharedFlow<VideoTrack>()
//    override val remoteVideoTrackFlow: SharedFlow<VideoTrack> = _remoteVideoTrackFlow

    // declaring video constraints and setting OfferToReceiveVideo to true
    // this step is mandatory to create valid offer and answer
    private val mediaConstraints = MediaConstraints().apply {
        mandatory.addAll(
            listOf(
                MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"),
                MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"),
            )
        )
    }

    // getting front camera
    private val videoCapturer: VideoCapturer by lazy { buildCameraCapturer() }
    private val cameraManager by lazy { context.getSystemService(Context.CAMERA_SERVICE) as CameraManager }
    private val cameraEnumerator: Camera2Enumerator by lazy {
        Camera2Enumerator(context)
    }

    private var connectionTracks = mutableListOf<RtpTransceiver>()
    private var added = false

    private val resolution: CameraEnumerationAndroid.CaptureFormat
        get() {
            val frontCamera = cameraEnumerator.deviceNames.first { cameraName ->
                cameraEnumerator.isFrontFacing(cameraName)
            }
            val supportedFormats = cameraEnumerator.getSupportedFormats(frontCamera) ?: emptyList()
            return supportedFormats.firstOrNull {
                (it.width == 720 || it.width == 480 || it.width == 360 || it.width == 320 || it.width == 640 || it.width == 1280)
            } ?: error("There is no matched resolution!")
        }

    // we need it to initialize video capturer
    private val surfaceTextureHelper = SurfaceTextureHelper.create(
        "SurfaceTextureHelperThread",
        peerConnectionFactory.eglBaseContext
    )

    private val videoSource by lazy {
        peerConnectionFactory.makeVideoSource(videoCapturer.isScreencast).apply {
            videoCapturer.initialize(surfaceTextureHelper, context, this.capturerObserver)
            videoCapturer.startCapture(resolution.width, resolution.height, 30)
        }
    }

//    private val localVideoTrack: VideoTrack by lazy {
//        peerConnectionFactory.makeVideoTrack(
//            source = videoSource,
//            trackId = "Video${UUID.randomUUID()}"
//        )
//    }

    /** Audio properties */
    private val audioManager by lazy {
        context.getSystemService<AudioManager>()
    }

    private val audioConstraints: MediaConstraints by lazy {
        buildAudioConstraints()
    }

    private val audioSource by lazy {
        peerConnectionFactory.makeAudioSource(audioConstraints)
    }

    private val localAudioTrack: AudioTrack by lazy {
        peerConnectionFactory.makeAudioTrack(
            source = audioSource,
            trackId = "Audio${UUID.randomUUID()}"
        )
    }

    private var offer: String? = null

    private val peerConnection: StreamPeerConnection by lazy {
        peerConnectionFactory.makePeerConnection(
            coroutineScope = sessionManagerScope,
            configuration = peerConnectionFactory.rtcConfig,
            type = StreamPeerType.SUBSCRIBER,
            mediaConstraints = mediaConstraints,
            onIceCandidateRequest = { iceCandidate, _ ->
                signalingClient.sendCommand(
                    SignalingCommand.ICE,
                    "${iceCandidate.sdpMid}$ICE_SEPARATOR${iceCandidate.sdpMLineIndex}$ICE_SEPARATOR${iceCandidate.sdp}"
                )
            },
            onVideoTrack = { rtpTransceiver ->
//                val track = rtpTransceiver?.receiver?.track() ?: return@makePeerConnection
//                connectionTracks.add(rtpTransceiver)
//                if (track.kind() == MediaStreamTrack.VIDEO_TRACK_KIND) {
//                    val videoTrack = track as VideoTrack
//                    sessionManagerScope.launch {
//                        _remoteVideoTrackFlow.emit(videoTrack)
//                    }
//                }
            }
        )
    }

    init {
        sessionManagerScope.launch {
            signalingClient.signalingCommandFlow.collect { commandToValue ->
                when (commandToValue.first) {
                    SignalingCommand.OFFER -> handleOffer(commandToValue.second)
                    SignalingCommand.ANSWER -> handleAnswer(commandToValue.second)
                    SignalingCommand.ICE -> handleIce(commandToValue.second)
                    else -> Unit
                }
            }
        }
    }

    override fun onSessionScreenReady() {
        setupAudio()
        if(!added){
//            peerConnection.connection.addTrack(localVideoTrack)
            peerConnection.connection.addTrack(localAudioTrack)
            added = true
        }

        sessionManagerScope.launch {
//             sending local video track to show local video from start
//            _localVideoTrackFlow.emit(localVideoTrack)

            if (offer != null) {
                sendAnswer()
            } else {
                sendOffer()
            }
        }
    }

    override fun flipCamera() {
        (videoCapturer as? Camera2Capturer)?.switchCamera(null)
    }

    override fun enableMicrophone(enabled: Boolean) {
        audioManager?.isMicrophoneMute = !enabled
    }

    override fun enableVolume(enabled: Boolean) {
        localAudioTrack.setEnabled(enabled)
    }

    override fun enableCamera(enabled: Boolean) {
        if (enabled) {
            videoCapturer.startCapture(resolution.width, resolution.height, 30)
        } else {
            videoCapturer.stopCapture()
        }
    }

    override fun disconnect() {
        // dispose audio & video tracks.
//        remoteVideoTrackFlow.replayCache.forEach { videoTrack ->
//            videoTrack.dispose()
//        }
//        localVideoTrackFlow.replayCache.forEach { videoTrack ->
//            videoTrack.dispose()
//        }
//        localAudioTrack.dispose()
//        localVideoTrack.dispose()

        // dispose audio handler and video capturer.
        audioHandler.stop()
        videoCapturer.stopCapture()
        videoCapturer.dispose()

        // dispose signaling clients and socket.
        signalingClient.dispose()

        sessionManagerScope.cancel()

        peerConnection.connection.close()

        connectionTracks.forEach {
            peerConnection.connection.removeTrack(it.sender)
        }
        connectionTracks.clear()
    }

    private suspend fun sendOffer() {
        val offer = peerConnection.createOffer().getOrThrow()
        val result = peerConnection.setLocalDescription(offer)
        result.onSuccess {
            signalingClient.sendCommand(SignalingCommand.OFFER, offer.description)
        }
        logger.d { "[SDP] send offer: ${offer.stringify()}" }
    }

    private suspend fun sendAnswer() {
        peerConnection.setRemoteDescription(
            SessionDescription(SessionDescription.Type.OFFER, offer)
        )
        val answer = peerConnection.createAnswer().getOrThrow()
        val result = peerConnection.setLocalDescription(answer)
        result.onSuccess {
            signalingClient.sendCommand(SignalingCommand.ANSWER, answer.description)
        }
        logger.d { "[SDP] send answer: ${answer.stringify()}" }
    }

    private fun handleOffer(sdp: String) {
        logger.d { "[SDP] handle offer: $sdp" }
        offer = sdp
    }

    private suspend fun handleAnswer(sdp: String) {
        logger.d { "[SDP] handle answer: $sdp" }
        peerConnection.setRemoteDescription(
            SessionDescription(SessionDescription.Type.ANSWER, sdp)
        )
    }

    private suspend fun handleIce(iceMessage: String) {
        val iceArray = iceMessage.split(ICE_SEPARATOR)
        peerConnection.addIceCandidate(
            IceCandidate(
                iceArray[0],
                iceArray[1].toInt(),
                iceArray[2]
            )
        )
    }

    private fun buildCameraCapturer(): VideoCapturer {
        val manager = cameraManager ?: throw RuntimeException("CameraManager was not initialized!")

        val ids = manager.cameraIdList
        var foundCamera = false
        var cameraId = ""

        for (id in ids) {
            val characteristics = manager.getCameraCharacteristics(id)
            val cameraLensFacing = characteristics.get(CameraCharacteristics.LENS_FACING)

            if (cameraLensFacing == CameraMetadata.LENS_FACING_FRONT) {
                foundCamera = true
                cameraId = id
            }
        }

        if (!foundCamera && ids.isNotEmpty()) {
            cameraId = ids.first()
        }

        return Camera2Capturer(context, cameraId, null)
    }

    private fun buildAudioConstraints(): MediaConstraints {
        val mediaConstraints = MediaConstraints()
        val items = listOf(
            MediaConstraints.KeyValuePair(
                "googEchoCancellation",
                true.toString()
            ),
            MediaConstraints.KeyValuePair(
                "googAutoGainControl",
                true.toString()
            ),
            MediaConstraints.KeyValuePair(
                "googHighpassFilter",
                true.toString()
            ),
            MediaConstraints.KeyValuePair(
                "googNoiseSuppression",
                true.toString()
            ),
            MediaConstraints.KeyValuePair(
                "googTypingNoiseDetection",
                true.toString()
            )
        )

        return mediaConstraints.apply {
            with(optional) {
                add(MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"))
                addAll(items)
            }
        }
    }

    private fun setupAudio() {
        logger.d { "[setupAudio] #sfu; no args" }
        audioHandler.start()
        audioManager?.mode = AudioManager.MODE_IN_COMMUNICATION
//        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL), 0)
//        audioManager.isSpeakerphoneOn = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val devices = audioManager?.availableCommunicationDevices ?: return
            val deviceType = AudioDeviceInfo.TYPE_BUILTIN_SPEAKER

            val device = devices.firstOrNull { it.type == deviceType } ?: return

            val isCommunicationDeviceSet = audioManager?.setCommunicationDevice(device)
            logger.d { "[setupAudio] #sfu; isCommunicationDeviceSet: $isCommunicationDeviceSet" }
        }
    }
}