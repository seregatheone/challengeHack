package core.ui.components.sceletons

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import core.ui.themes.AppResources
import core.ui.components.sceletons.SkeletonAnimations.animationDuration
import core.ui.components.sceletons.SkeletonAnimations.initialValue
import core.ui.components.sceletons.SkeletonAnimations.targetValue


/**
 * Стандартный элемент для отображения скелетонов
 * @param shape - для нестандартных форм скелетонов
 * @param skeletonStyle для отображения нужного цвета скелетона(GreyStyle, RedStyle)
 */
@Composable
fun AnimatedSkeletons(
    modifier: Modifier = Modifier,
    shape : Shape? = null,
    skeletonStyle: SkeletonStyle = SkeletonStyle.PurpleStyle
) {
//    val shimmerColors =listOf(
//            AppResources.colors.DarkPurple,
//            AppResources.colors.PurpleGreyMedium,
//            AppResources.colors.DarkPurple
//        )

    val transition = rememberInfiniteTransition(label = "")

    val translateAnim = transition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = listOf(Color.Red),
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )


    if(shape != null){
        Spacer(
            modifier = modifier
                .background(
                    brush,
                    shape
                )
        )
    }else{
        Spacer(
            modifier = modifier
                .background(
                    brush
                )
        )
    }

}