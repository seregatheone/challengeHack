package pat.project.challengehack.screens.main.mainScreen.models

sealed class MainNavDirections {
    object Default : MainNavDirections()
    class Genre(
        val genreName : String
    ) : MainNavDirections()

    class Release(
        val albumId : Int
    ) : MainNavDirections()

}