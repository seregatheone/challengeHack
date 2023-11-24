package pat.project.challengehack.screens.main.mainScreen.models

sealed class MainNavDirections {
    object Default : MainNavDirections()
    object FriendList : MainNavDirections()
    class Chat(
        val chatId : Int
    ) : MainNavDirections()

    class Server(
        val serverId : Int
    ) : MainNavDirections()

}