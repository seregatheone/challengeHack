package core.ui.themes.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle


data class Typography(
    val headlines : Int
)

//data class Display(
//)
//
//data class Headlines(
//)
//
//data class Titles(
//
//    )
//
//data class Label(
//
//    )
//
//data class Body(
//)
//
//data class Link(
//)

val LocalAppTypography = staticCompositionLocalOf<Typography> {
    error("No AppTypography provided")
}