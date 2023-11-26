package core.ui.components.sceletons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

/**
 * Для стандартного скелетона любой формы(скелетон должен быть один)
 */

@Composable
fun SkeletonWithContent(
    modifier: Modifier = Modifier,
    shape: Shape? = null,
    skeletonStyle: SkeletonStyle = SkeletonStyle.PurpleStyle,
    showSkeleton: Boolean,
    screenContent: @Composable () -> Unit
) {
    if (showSkeleton) {
        AnimatedSkeletons(
            modifier = modifier,
            shape = shape,
            skeletonStyle = skeletonStyle,
        )
    }else{
        screenContent()
    }

}