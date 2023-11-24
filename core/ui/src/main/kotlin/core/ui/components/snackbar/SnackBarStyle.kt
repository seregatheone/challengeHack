package core.ui.components.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import core.ui.themes.AppResources
import core.ui.themes.colors.AppColors
import core.ui.themes.typography.Typography

sealed class SnackBarStyle {
    abstract val textColor: Color
    abstract val backgroundColor: Color
    abstract val textStyle : TextStyle

    private var _appColors: AppColors? = null
    protected val appColors get() = _appColors!!

    private var _appTypography: Typography? = null
    val appTypography get() = _appTypography!!

    @Composable
    fun InitResources() {
        _appColors = AppResources.colors
        _appTypography = AppResources.typography
    }

    @Composable
    abstract fun initResourcesImpl(): SnackBarStyle

    object RedStyle :
        SnackBarStyle() {
        override val textColor: Color
            get() = TODO()
        override val backgroundColor: Color
            get() = TODO()
        override val textStyle: TextStyle
            get() = TODO()


        @Composable
        override fun initResourcesImpl(): RedStyle {
            super.InitResources()
            return this
        }
    }

    object GreenStyle :
        SnackBarStyle() {
        override val textColor: Color
            get() = TODO()
        override val backgroundColor: Color
            get() = TODO()
        override val textStyle: TextStyle
            get() = TODO()


        @Composable
        override fun initResourcesImpl(): GreenStyle {
            super.InitResources()
            return this
        }

    }
}