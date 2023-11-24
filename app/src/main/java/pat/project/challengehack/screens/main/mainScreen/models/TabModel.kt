package pat.project.challengehack.screens.main.mainScreen.models

import androidx.annotation.StringRes
import pat.project.challengehack.R

enum class TabModel (
    @StringRes
    val tabName : Int,
    val order : Int,
){
//    ServerTab(R.string.servers_tab, 0),
//    DirectMessagesTab(R.string.direct_messages_tab, 1),
}