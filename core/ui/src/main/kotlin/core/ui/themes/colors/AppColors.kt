package core.ui.themes.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
sealed class AppColors(
    val Black: Color,
    val Grey: Color,
    val White: Color,
    val MainRed: Color,
    val Online: Color,
    val Grey60: Color,
    val Grey70: Color,
    val Grey80: Color,
    val Grey90: Color,
    val Grey90_60: Color,
    val SystemError: Color,
) {
    class DarkThemeAppColors : AppColors(
        Black = Black,
        Grey = Grey,
        White = White,
        MainRed = MainRed,
        Online = Online,
        Grey60 = Grey60,
        Grey70 = Grey70,
        Grey80 = Grey80,
        Grey90 = Grey90,
        Grey90_60 = Grey90_60,
        SystemError = SystemError,
    )
}


fun appColors(darkTheme: Boolean): AppColors = when (darkTheme) {
    true -> AppColors.DarkThemeAppColors()
    false -> AppColors.DarkThemeAppColors()
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColors provided")
}
