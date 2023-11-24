package core.ui.themes.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle


data class Typography(
    val headlines : Headlines,
    val display : Display,
    val titles : Titles,
    val label : Label,
    val body : Body,
    val links: Link
)

data class Display(
    val display : TextStyle
)

data class Headlines(
    val headline0 : TextStyle,
    val headline1 : TextStyle,
    val headline2 : TextStyle,
)

data class Titles(
    val title0 : TextStyle,
    val title1 : TextStyle,
    val title2 : TextStyle,

    )

data class Label(
    val label0 : TextStyle,
    val label1 : TextStyle,
    val label2 : TextStyle,

    )

data class Body(
    val body0 : TextStyle,
    val body1 : TextStyle,
    val body2 : TextStyle,
)

data class Link(
    val link2: TextStyle,
)

val LocalAppTypography = staticCompositionLocalOf<Typography> {
    error("No AppTypography provided")
}