package pat.project.challengehack.navigation.bottomNavigation

import androidx.annotation.DrawableRes
import pat.project.challengehack.R

sealed class BottomNavigationItem(
    @DrawableRes
    val iconId: Int,
    val itemName : String
) {
    object MainItem : BottomNavigationItem(
        iconId = R.drawable.ic_botton_nav_bar_main,
        itemName = mainItemName
    )

    object LibItem : BottomNavigationItem(
        iconId =  R.drawable.ic_lucide_library_big,
        itemName = libItem
    )

    object FriendsItem : BottomNavigationItem(
        iconId = R.drawable.ic_botton_nav_bar_friends,
        itemName = friendsItem
    )

    object Profile: BottomNavigationItem(
        iconId = R.drawable.ic_botton_nav_bar_profile,
        itemName = profileItem
    )

    companion object{
        const val mainItemName = "mainItem"
        const val libItem = "libItem"
        const val friendsItem = "friendsItem"
        const val profileItem = "profileItem"
    }
}