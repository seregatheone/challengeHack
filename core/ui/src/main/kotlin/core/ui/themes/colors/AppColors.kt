package core.ui.themes.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
sealed class AppColors(
    val Black: Color,
    val Grey: Color,
    val White: Color,
    val SystemError: Color,
    val Online: Color,
) {
    class DarkThemeAppColors : AppColors(
        Black = Black,
        Grey = Grey,
        White = White,
        SystemError = SystemError,
        Online = Online,
    )
}


fun appColors(darkTheme: Boolean): AppColors = when (darkTheme) {
    true -> AppColors.DarkThemeAppColors()
    false -> AppColors.DarkThemeAppColors()
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColors provided")
}
