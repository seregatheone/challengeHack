package pat.project.challengehack.screens.profile.profileScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pat.project.challengehack.screens.profile.profileScreen.models.CategoryItem

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    categorySettings: CategoryItem,
    onClick: () -> Unit = {},
) {
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(
//                color = AppResources.colors.DarkPurple,
//                shape = RoundedCornerShape(6.dp)
//            )
//            .padding(horizontal = 14.dp, vertical = 14.dp)
//            .clickable { onClick() }
//    ) {
//        Icon(
//            modifier = Modifier.size(24.dp),
//            imageVector = categorySettings.itemIcon,
//            tint = AppResources.colors.White,
//            contentDescription = null
//        )
//
//        Text(
//            modifier = Modifier
//                .padding(start = 18.dp)
//                .weight(1f),
//            text = stringResource(id = categorySettings.itemName),
//            style = AppResources.typography.body.body0,
//            color = AppResources.colors.White
//        )
//
//        Icon(
//            modifier = Modifier.size(24.dp),
//            imageVector = Icons.Filled.ArrowForwardIos,
//            tint = AppResources.colors.White,
//            contentDescription = null
//        )
//    }
}