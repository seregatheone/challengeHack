package core.ui.themes.typography

import android.view.Display
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import core.ui.themes.dimens.AppDimens
import pat.project.challengehack.core.ui.R


fun appTypography(dims: AppDimens): Typography = Typography(
    headlines = Headlines(
        headline0 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize24,
            lineHeight = dims.textSizes.textSize20
        ),
        headline1 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize22,
            lineHeight = dims.textSizes.textSize40
        ),
        headline2 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize24,
            lineHeight = dims.textSizes.textSize32
        ),
    ),

    display = Display(
        display = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize57,
            lineHeight = dims.textSizes.textSize64
        )
    ),

    titles = Titles(
        title0 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize16,
            lineHeight = dims.textSizes.textSize20,
        ),
        title1 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize16,
            lineHeight = dims.textSizes.textSize20,
            letterSpacing = dims.textSizes.textSize0_15,
        ),
        title2 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize14,
            lineHeight = dims.textSizes.textSize20,
            letterSpacing = dims.textSizes.textSize0_1
        ),
    ),
    label = Label(
        label0 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize14,
            lineHeight = dims.textSizes.textSize20,
            letterSpacing = dims.textSizes.textSize0_1
        ),
        label1 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize12,
            lineHeight = dims.textSizes.textSize16,
            letterSpacing = dims.textSizes.textSize0_5
        ),
        label2 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize11,
            lineHeight = dims.textSizes.textSize16,
            letterSpacing = dims.textSizes.textSize0_5
        ),
    ),
    body = Body(
        body0 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize14,
            lineHeight = dims.textSizes.textSize20,
            letterSpacing = dims.textSizes.textSize0_5
        ),
        body1 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize14,
            lineHeight = dims.textSizes.textSize20,
            letterSpacing = dims.textSizes.textSize0_25
        ),
        body2 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize14,
            lineHeight = dims.textSizes.textSize20,
            letterSpacing = dims.textSizes.textSize0_4
        ),
    ),
    links = Link(
        link2 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize16,
            lineHeight = dims.textSizes.textSize24,
            letterSpacing = dims.textSizes.textSize0_15
        )
    ),
    subTitle = SubTitle(
        subtitle0 = TextStyle(
            fontFamily = AppFontFamilies.Roboto,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize12,
            lineHeight = dims.textSizes.textSize20,
            letterSpacing = dims.textSizes.textSize0_15
        )
    )

)




@Immutable
object AppFontFamilies {
    @Stable
    val Roboto = FontFamily(
        Font(resId = R.font.roboto_regular, weight = FontWeight.W400, style = FontStyle.Normal),
        Font(resId = R.font.roboto_medium, weight = FontWeight.W500, style = FontStyle.Normal),
        Font(resId = R.font.roboto_bold, weight = FontWeight.W700, style = FontStyle.Normal),
    )
}