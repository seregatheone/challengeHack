package pat.project.challengehack.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import pat.project.challengehack.navigation.utils.navigateAndClean
import pat.project.challengehack.screens.authRegLoading.auth.AuthorizationScreen
import pat.project.challengehack.screens.authRegLoading.featureloading.FeatureLoadingScreen
import pat.project.challengehack.screens.authRegLoading.registration.RegistrationScreen
import pat.project.challengehack.screens.authRegLoading.welcomepage.WelcomePageScreen
import pat.project.challengehack.screens.container.ContainerScreen
import pat.project.challengehack.screens.friends.friendsScreen.FriendsScreen
import pat.project.challengehack.screens.library.LibraryScreen
import pat.project.challengehack.screens.main.mainScreen.MainScreen
import pat.project.challengehack.screens.profile.profileScreen.ProfileScreen


@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    ContainerScreen(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
    ) {
        NavHost(
            modifier = modifier,
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
                        modifier = Modifier.fillMaxSize(),
                        navigateToFriendsListWithPopBack = {
                            navController.navigateAndClean(
                                Screens.Friends.destination()
                            )
                        },
                        navigateToChat = { chatId ->
//                        navController.navigate(
//                            Screens.DirectMessagesScreen.destination(chatId)
//                        )
                        },
                        navigateToServer = { serverId ->
//                        navController.navigate(
//                            Screens.Servers.destination(serverId)
//                        )
                        },
                    )
                }
                composable(route = Screens.Friends.screenRoute) {
                    FriendsScreen(
                        modifier = Modifier.fillMaxSize(),
                        navigateToFriendsRequest = {
//                        navController.navigateAndClean(
//                            Screens.FriendsRequest.destination()
//                        )
                        },
                        navigateToCall = { userId ->
//                        navController.navigate(
//                            Screens.Call.destination(userId)
//                        )
                        },
                        navigateToChat = { chatId ->
//                        navController.navigate(
//                            Screens.DirectMessagesScreen.destination(chatId)
//                        )
                        }
                    )
                }
                composable(route = Screens.Library.screenRoute) {
                    LibraryScreen(
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                composable(route = Screens.profileScreenRoute) {
                    ProfileScreen(
                        modifier = Modifier.fillMaxSize(),
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

    object Library : Screens(
        screenRoute = libraryScreenRoute,
    ) {
        fun destination(): String {
            return libraryScreenRoute
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
        const val USER_ID = "userId"
        const val CHAT_ID = "chatId"
        const val SERVER_ID = "serverId"
        const val CHAT_ID_DEFAULT = 0
        const val USER_ID_DEFAULT = 0


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
        const val serversScreenRoute = "serversScreen"
        const val friendsRequestScreenRoute = "friendsRequestScreen"
        const val profileScreenRoute = "profileScreen"
        const val accountSettingsRoute = "accountPage"
        const val passwordScreen = "passwordScreen"
        const val changesSavedScreen = "changesSavedScreen"

        const val callPageScreenRoute = "callPageRoute"
        const val directMessagesScreen = "directMessagesScreenRoute"
    }
}