package impl.data.stomp

enum class TrackActionEntity(
    val trackName : String
) {
    ADD(trackName = "add"),
    NOW(trackName = "now"),
    PAUSE(trackName = "pause"),
    RELEASE(trackName = "release")
}