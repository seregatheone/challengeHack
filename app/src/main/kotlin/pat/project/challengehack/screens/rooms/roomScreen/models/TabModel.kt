package pat.project.challengehack.screens.rooms.roomScreen.models

import androidx.annotation.StringRes
import pat.project.challengehack.R

enum class TabModel (
    @StringRes
    val tabName : Int,
    val order : Int,
){
    ParticipantsAdvices(R.string.participants_advices, 0),
    ParticipantsQueue(R.string.participants_queue, 1),
}