package core.ui.components.sceletons

import androidx.compose.runtime.Composable


/**
 * Если нестандартный скелетон(несколько скелетонов или др.), то их можно создать в функции
 */
@Composable
fun SkeletonContentWithContent(
    showSkeleton: Boolean,
    skeletonContent : @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    if (showSkeleton) {
        skeletonContent()
    }else{
        content()
    }

}