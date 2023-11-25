package pat.project.challengehack.screens.rooms.roomsScreenStart.models

sealed class RoomsNavDirections {
    object Default: RoomsNavDirections()
    object RoomScreen : RoomsNavDirections()
}