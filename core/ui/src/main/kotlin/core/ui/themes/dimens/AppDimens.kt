package core.ui.themes.dimens


import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

val LocalAppDimens = staticCompositionLocalOf<AppDimens> {
    error("No AppDims provided")
}

fun appDimens() = AppDimens(
    textSizes = regularTextSizes,
)

@Immutable
data class AppDimens(
    val textSizes : TextSizes,
)

data class TextSizes(
    val textSize64: TextUnit,
    val textSize57: TextUnit,
    val textSize48: TextUnit,
    val textSize40: TextUnit,
    val textSize36: TextUnit,
    val textSize34: TextUnit,
    val textSize32: TextUnit,
    val textSize28: TextUnit,
    val textSize24: TextUnit,
    val textSize22: TextUnit,
    val textSize20: TextUnit,
    val textSize18: TextUnit,
    val textSize16: TextUnit,
    val textSize14: TextUnit,
    val textSize12: TextUnit,
    val textSize11: TextUnit,
    val textSize10: TextUnit,
    val textSize8: TextUnit,
    val textSize6: TextUnit,
    val textSize5: TextUnit,
)



internal val regularTextSizes = TextSizes(
    textSize64 = 64.sp,
    textSize57 = 57.sp,
    textSize48 = 48.sp,
    textSize40 = 40.sp,
    textSize36 = 36.sp,
    textSize34 = 34.sp,
    textSize32 = 32.sp,
    textSize28 = 28.sp,
    textSize24 = 24.sp,
    textSize22= 22.sp,
    textSize20 = 20.sp,
    textSize18 = 18.sp,
    textSize16 = 16.sp,
    textSize14 = 14.sp,
    textSize12 = 12.sp,
    textSize11 = 11.sp,
    textSize10 = 10.sp,
    textSize8 = 8.sp,
    textSize6 = 6.sp,
    textSize5 = 5.sp,
)

