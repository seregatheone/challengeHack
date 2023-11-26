package pat.project.challengehack.screens.profile.profileScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources
import pat.project.challengehack.screens.profile.profileScreen.models.CategoryItem

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    categorySettings: CategoryItem,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = AppResources.colors.Grey90_60,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 14.dp, vertical = 14.dp)
            .clickable { onClick() }
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = categorySettings.itemIcon,
            tint = AppResources.colors.White,
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .padding(start = 18.dp)
                .weight(1f),
            text = stringResource(id = categorySettings.itemName),
            style = AppResources.typography.body.body0,
            color = AppResources.colors.White
        )

        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Filled.ArrowForwardIos,
            tint = AppResources.colors.White,
            contentDescription = null
        )
    }
}