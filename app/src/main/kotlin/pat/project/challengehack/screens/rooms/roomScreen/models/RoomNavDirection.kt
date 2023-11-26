package pat.project.challengehack.screens.rooms.roomScreen.models

import pat.project.challengehack.screens.main.mainScreen.models.MainNavDirections

sealed class RoomNavDirection {
    object Default : RoomNavDirection()
    object PopBackStack: RoomNavDirection()

}