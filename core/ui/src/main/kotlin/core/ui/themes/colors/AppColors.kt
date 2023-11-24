package core.ui.themes.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
sealed class AppColors(

) {
    class DarkThemeAppColors : AppColors(

    )
}


fun appColors(darkTheme: Boolean): AppColors = when (darkTheme) {
    true -> AppColors.DarkThemeAppColors()
    false -> AppColors.DarkThemeAppColors()
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColors provided")
}
