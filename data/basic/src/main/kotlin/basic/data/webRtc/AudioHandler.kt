package basic.data.webRtc

interface AudioHandler {
  /**
   * Called when a room is started.
   */
  fun start()

  /**
   * Called when a room is disconnected.
   */
  fun stop()
}