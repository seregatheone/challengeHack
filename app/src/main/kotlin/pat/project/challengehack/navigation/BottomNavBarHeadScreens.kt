package pat.project.challengehack.navigation

import pat.project.challengehack.navigation.bottomNavigation.BottomNavigationItem

sealed class BottomNavBarHeadScreens(
    val route: String,
    val bottomNavIcon: BottomNavigationItem
) {
    object Main : BottomNavBarHeadScreens(
        route = mainScreenRoute,
        bottomNavIcon = BottomNavigationItem.MainItem
    )

    object Library : BottomNavBarHeadScreens(
        route = libraryScreenRoute,
        bottomNavIcon = BottomNavigationItem.LibItem
    )

    object Friends : BottomNavBarHeadScreens(
        route = friendsScreenRoute,
        bottomNavIcon = BottomNavigationItem.FriendsItem
    )

    object Profile : BottomNavBarHeadScreens(
        route = profileScreenRoute,
        bottomNavIcon = BottomNavigationItem.Profile
    )

    companion object {
        const val mainScreenRoute = "mainScreen"
        const val friendsScreenRoute = "friendsScreen"
        const val libraryScreenRoute = "libraryScreen"
        const val profileScreenRoute = "profileScreen"

        fun getScreen(destinationHead: String?): BottomNavBarHeadScreens? {
            return when (destinationHead) {
                Profile.route -> Profile
                Library.route -> Library
                Friends.route -> Friends
                Main.route -> Main
                else -> {
                    null
                }
            }
        }
    }
}