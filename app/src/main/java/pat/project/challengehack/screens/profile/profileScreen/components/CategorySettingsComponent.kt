package pat.project.challengehack.screens.profile.profileScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pat.project.challengehack.screens.profile.profileScreen.models.CategorySettings

@Composable
fun CategorySettingsComponent(
    modifier: Modifier = Modifier,
    categorySettings: CategorySettings,
    navigateToAccountSettings: () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
//        Text(
//            modifier = Modifier.padding(bottom = 12.dp),
//            text = stringResource(id = categorySettings.categoryName),
//            style = AppResources.typography.titles.title0,
//            color = AppResources.colors.White
//        )

        categorySettings.categoryItems.forEach { item ->
            when (item.itemId) {
                1 -> SettingsItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    categorySettings = item,
                    onClick = navigateToAccountSettings,
                )

                else -> SettingsItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    categorySettings = item,
                    onClick = { },
                )
            }

        }

    }
}
