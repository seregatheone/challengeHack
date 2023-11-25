package pat.project.challengehack.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import pat.project.challengehack.navigation.Screens.Companion.MY_DEFAULT_ID
import pat.project.challengehack.navigation.Screens.Companion.MY_ID
import pat.project.challengehack.navigation.Screens.Companion.ROOM_DEFAULT_ID
import pat.project.challengehack.navigation.Screens.Companion.ROOM_ID
import pat.project.challengehack.navigation.Screens.Companion.ALBUM_ID
import pat.project.challengehack.navigation.Screens.Companion.ALBUM_ID_DEFAULT
import pat.project.challengehack.navigation.Screens.Companion.GENRE_NAME
import pat.project.challengehack.navigation.Screens.Companion.GENRE_NAME_DEFAULT
import pat.project.challengehack.navigation.utils.navigateAndClean
import pat.project.challengehack.screens.album.AlbumSreen
import pat.project.challengehack.screens.authRegLoading.auth.AuthorizationScreen
import pat.project.challengehack.screens.authRegLoading.featureloading.FeatureLoadingScreen
import pat.project.challengehack.screens.authRegLoading.registration.RegistrationScreen
import pat.project.challengehack.screens.authRegLoading.welcomepage.WelcomePageScreen
import pat.project.challengehack.screens.chats.groupChat.GroupChatScreen
import pat.project.challengehack.screens.container.ContainerScreen
import pat.project.challengehack.screens.friends.friendsScreen.FriendsScreen
import pat.project.challengehack.screens.genre.GenreScreen
import pat.project.challengehack.screens.library.LibraryScreen
import pat.project.challengehack.screens.main.mainScreen.MainScreen
import pat.project.challengehack.screens.profile.profileScreen.ProfileScreen
import pat.project.challengehack.screens.rooms.roomScreen.RoomScreen
import pat.project.challengehack.screens.rooms.roomsScreenStart.RoomsStartScreen


@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    ContainerScreen(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
    ) { padding ->
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = Screens.FeatureLoading.screenRoute,
        ) {
            composable(route = Screens.FeatureLoading.screenRoute) {
                FeatureLoadingScreen(
                    modifier = Modifier.fillMaxSize(),
                    navigateToWelcomePage = {
                        navController.navigate(Screens.WelcomePage.destination())
                    },
                    navigateToMainScreen = {
                        navController.navigate(Screens.ContainerScreen.destination())
                    }
                )
            }

            composable(route = Screens.WelcomePage.screenRoute) {
                WelcomePageScreen(
                    modifier = Modifier.fillMaxSize(),
                    navigateToAuthorization = {
                        navController.navigate(Screens.Authorization.destination())
                    },
                    navigateToRegistration = {
                        navController.navigate(Screens.Registration.destination())
                    },
                )
            }

            composable(route = Screens.Authorization.screenRoute) {
                AuthorizationScreen(
                    modifier = Modifier.fillMaxSize(),
                    onclickBack = {
                        navController.navigate(Screens.WelcomePage.destination())
                    },
                    onclickReg = {
                        navController.navigate(Screens.Registration.destination())
                    },
                    navigateToMainWithPopBackStack = {
                        navController.navigate(
                            Screens.ContainerScreen.destination()
                        )
                    },
                )
            }

            composable(route = Screens.Registration.screenRoute) {
                RegistrationScreen(
                    modifier = Modifier.fillMaxSize(),
                    onclickBack = {
                        navController.navigate(Screens.WelcomePage.destination())
                    },
                    navigateToMainWithPopBackStack = {
                        navController.navigateAndClean(
                            Screens.ContainerScreen.destination()
                        )
                    },
                )
            }

            navigation(
                startDestination = Screens.Main.screenRoute,
                route = Screens.ContainerScreen.screenRoute
            ) {
                composable(route = Screens.Main.screenRoute) {
                    MainScreen(
                        modifier = padding,
                        navigateToFriendsListWithPopBack = {
                            navController.navigateAndClean(
                                Screens.Friends.destination()
                            )
                        },
                        navigateToGenre = { genreName ->
                            navController.navigate(
                                Screens.Genre.destination(genreName)
                            )
                        },
                        navigateToRelease = { albumId ->
                        navController.navigate(
                            Screens.Album.destination(albumId)
                        )
                        },
                    )
                }
                composable(route = Screens.Friends.screenRoute) {
                    RoomsStartScreen(
                        modifier = Modifier.fillMaxSize(),
                        navigateToRoomScreen = {}
                    )
                }

                composable(route = Screens.Library.screenRoute) {
                    LibraryScreen(
                        modifier = padding,
                    )
                }

                composable(route = Screens.Genre.screenRoute) { backStackEntry ->
                    val genreName =
                        backStackEntry.arguments?.getString(GENRE_NAME)?: GENRE_NAME_DEFAULT
                    GenreScreen(
                        modifier = Modifier.fillMaxSize(),
                        genreName = genreName,
                        onclickBack = {
                            navController.navigate(Screens.Main.destination())
                        },
                    )
                }

                composable(route = Screens.Album.screenRoute) { backStackEntry ->
                    val albumId =
                        backStackEntry.arguments?.getString(ALBUM_ID)?.toInt()?: ALBUM_ID_DEFAULT
                    AlbumSreen(
                        modifier = Modifier.fillMaxSize(),
                        albumId = albumId,
                        onclickBack = {
                            navController.navigate(Screens.Main.destination())
                        },
                    )
                }

                composable(route = Screens.profileScreenRoute) {
                    ProfileScreen(
                        modifier = padding,
                        navigateToWelcomePageWithPopBackStack = {
                            navController.navigateAndClean(
                                Screens.WelcomePage.destination()
                            )
                        },
                        navigateToAccountSettings = {
//                        navController.navigateAndClean(
//                            Screens.AccountSettingsPage.destination()
//                        )
                        }
                    )
                }
            }

            composable(
                route = Screens.RoomScreen.screenRoute,
                deepLinks = listOf(navDeepLink {
                    uriPattern = "http://300notes/room/join/{$ROOM_ID}"
                })
            ) { backStackEntry ->
                val roomId = backStackEntry.arguments?.getString(ROOM_ID)?.toLong() ?: ROOM_DEFAULT_ID

                RoomScreen(
                    modifier = Modifier.fillMaxSize(),
                    roomId = roomId,
                    onClickBack = {
                        navController.popBackStack()
                    },
                    navigateToChat = { mineId : Long ->
                        navController.navigate(
                            Screens.GroupChat.destination(
                                mineId = mineId,
                                chat = roomId
                            )
                        )
                    }
                )
            }

            composable(
                route = Screens.GroupChat.screenRoute
            ) { backStackEntry ->
                val mineId = backStackEntry.arguments?.getString(MY_ID)?.toLong() ?: MY_DEFAULT_ID
                val roomId = backStackEntry.arguments?.getString(ROOM_ID)?.toLong() ?: ROOM_DEFAULT_ID

                GroupChatScreen(
                    modifier = Modifier.fillMaxSize(),
                    myId = mineId,
                    roomId = roomId,
                    onBackPressed = {
                        navController.popBackStack()
                    }
                )
            }




        }
    }

}


sealed class Screens(
    val screenRoute: String
) {

    abstract val arguments: List<NamedNavArgument>

    //////////////////////////// BEFORE CONTAINER
    object FeatureLoading : Screens(featureLoadingScreen) {
        fun destination(): String {
            return featureLoadingScreen
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object Authorization : Screens(authorizationScreen) {
        fun destination(): String {
            return authorizationScreen
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object Registration : Screens(registrationScreen) {
        fun destination(): String {
            return registrationScreen
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object WelcomePage : Screens(welcomePageScreen) {
        fun destination(): String {
            return welcomePageScreen
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    ////////////////////////////
    object ContainerScreen : Screens(containerScreen) {

        fun destination(): String {
            return containerScreen
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()

    }

    //////////////////////////////

    object Main : Screens(
        screenRoute = mainScreenRoute,
    ) {
        fun destination(): String {
            return mainScreenRoute
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object Friends : Screens(
        screenRoute = friendsScreenRoute,
    ) {
        fun destination(): String {
            return friendsScreenRoute
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object RoomScreen : Screens(
        screenRoute = "$roomScreenRoute/{$ROOM_ID}"
    ) {
        fun destination(roomId: String): String {
            return "$roomScreenRoute/$roomId"
        }

        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument(ROOM_ID) {
                    type = NavType.StringType
                }
            )

    }

    object GroupChat : Screens(
        screenRoute = "$groupChatScreenRoute/{$MY_ID}/{$ROOM_ID}"
    ) {
        fun destination(mineId: Long, chat : Long): String {
            return "$roomScreenRoute/$mineId/$chat"
        }

        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument(MY_ID) {
                    type = NavType.StringType
                },
                navArgument(ROOM_ID) {
                    type = NavType.StringType
                }
            )

    }

    object Library : Screens(
        screenRoute = libraryScreenRoute,
    ) {
        fun destination(): String {
            return libraryScreenRoute
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object Genre : Screens(
        screenRoute = "$genreScreenRoute/{$GENRE_NAME}",
    ) {
        fun destination(genreName: String): String {
            return "$genreScreenRoute/$genreName"
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object Album : Screens(
        screenRoute = "$albumScreenRoute/{$ALBUM_ID}",
    ) {
        fun destination(albumId: Int): String {
            return "$albumScreenRoute/$albumId"
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    object Profile : Screens(
        screenRoute = profileScreenRoute,
    ) {
        fun destination(): String {
            return profileScreenRoute
        }

        override val arguments: List<NamedNavArgument>
            get() = emptyList()
    }

    companion object {
        //Arguments
        const val MY_ID = "myId"
        const val MY_DEFAULT_ID = 0L

        const val GENRE_NAME = "genreName"
        const val ALBUM_ID = "albumId"
        const val SERVER_ID = "serverId"
        const val CHAT_ID_DEFAULT = 0
        const val ALBUM_ID_DEFAULT = 0
        const val GENRE_NAME_DEFAULT = ""
        const val USER_ID_DEFAULT = 0

        const val ROOM_ID = "roomId"
        const val ROOM_DEFAULT_ID = 0L


        const val REDIRECTION_STATUS = "RedirectionStatus"

        //Screens
        const val featureLoadingScreen = "featureLoadingScreen"
        const val authorizationScreen = "authorizationScreen"
        const val registrationScreen = "registrationScreen"
        const val welcomePageScreen = "welcomePageScreen"

        const val containerScreen = "containerScreen"

        const val mainScreenRoute = "mainScreen"
        const val friendsScreenRoute = "friendsScreen"
        const val libraryScreenRoute = "libraryScreen"
        const val groupChatScreenRoute = "groupChatScreenRoute"
        const val genreScreenRoute = "genreScreen"
        const val albumScreenRoute = "albumScreen"
        const val serversScreenRoute = "serversScreen"
        const val roomScreenRoute = "roomScreen"
        const val profileScreenRoute = "profileScreen"
        const val accountSettingsRoute = "accountPage"
        const val passwordScreen = "passwordScreen"
        const val changesSavedScreen = "changesSavedScreen"

        const val callPageScreenRoute = "callPageRoute"
        const val directMessagesScreen = "directMessagesScreenRoute"
    }
}