package pat.project.conversay.screens.friends.friendsScreen.models

sealed class FriendsNavDirections {
    object Default: FriendsNavDirections()
    object FriendRequests : FriendsNavDirections()
    class Call(
        val userId : Int
    ) : FriendsNavDirections()

    class Chat(
        val chatId : Int
    ) : FriendsNavDirections()
}