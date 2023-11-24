package core.ui.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import core.ui.themes.colors.AppColors
import core.ui.themes.colors.LocalAppColors
import core.ui.themes.colors.appColors
import core.ui.themes.dimens.AppDimens
import core.ui.themes.dimens.LocalAppDimens
import core.ui.themes.dimens.appDimens
import core.ui.themes.typography.LocalAppTypography
import core.ui.themes.typography.Typography
import core.ui.themes.typography.appTypography

object AppResources {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current

    val dimens: AppDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimens.current

}

@Composable
fun ChallengeHackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val systemUiController = rememberSystemUiController()

    val dimensions: AppDimens = appDimens()
    val ourColors: AppColors = appColors(darkTheme)
    val appTypography: Typography = appTypography(dimensions)

//    SideEffect {
//        systemUiController.setStatusBarColor(
//            color = ourColors.SystemHeader,
//            darkIcons = false
//        )
//    }


    MaterialTheme(
        colorScheme = darkColorScheme().copy(
//                surface = ourColors.PurpleBlack,
//                primary = ourColors.PurpleBlack,
//                primaryContainer = ourColors.PurpleBlack,
//                onSurface = ourColors.PurpleBlack
            )
    ) {
        CompositionLocalProvider(
            LocalAppColors provides ourColors,
            LocalAppTypography provides appTypography,
            LocalAppDimens provides dimensions,
            content = content
        )
    }

}
