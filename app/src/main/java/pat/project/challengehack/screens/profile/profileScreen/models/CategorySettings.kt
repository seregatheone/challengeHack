package pat.project.challengehack.screens.profile.profileScreen.models

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class CategorySettings(
    @StringRes
    val categoryName: Int,
    val categoryItems: List<CategoryItem>,
) {

//    object AccountSettings : CategorySettings(
//        categoryName = R.string.account_settings_category_name,
//        categoryItems = listOf(
//            CategoryItem(
//                itemName = R.string.account_item_name,
//                itemIcon = Icons.Outlined.Person,
//                onClick = {  },
//                itemId = 1
//            ),
//            CategoryItem(
//                itemName = R.string.profile_appearance_item_name,
//                itemIcon = Icons.Outlined.Edit,
//                onClick = { },
//                itemId = 2
//            ),
//            CategoryItem(
//                itemName = R.string.friend_requests_item_name,
//                itemIcon = Icons.Outlined.GroupAdd,
//                onClick = { },
//                itemId = 3
//            )
//        )
//    )
//
//    object AppSettings : CategorySettings(
//        categoryName = R.string.app_settings_category_name,
//        categoryItems = listOf(
//            CategoryItem(
//                itemName = R.string.voice_item_name,
//                itemIcon = Icons.Outlined.Mic,
//                onClick = {},
//                itemId = 4
//            ),
//            CategoryItem(
//                itemName = R.string.language_item_name,
//                itemIcon = Icons.Outlined.Language,
//                onClick = {},
//                itemId = 5
//            ),
//            CategoryItem(
//                itemName = R.string.notifications_item_name,
//                itemIcon = Icons.Outlined.NotificationsActive,
//                onClick = {},
//                itemId = 6
//            )
//        )
//    )
}

data class CategoryItem(
    @StringRes
    val itemName: Int,
    val itemIcon: ImageVector,
    val onClick: () -> Unit,
    val itemId: Int,
)

