package core.ui.components.desingElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun BlindTalksComponent(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.Red,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
//            Text(
//                text = stringResource(id = R.string.card_friends_title),
//                style = AppResources.typography.headlines.headline0,
//                color = AppResources.colors.YellowGold
//            )
//            Text(
//                text = stringResource(id = R.string.card_friends_text),
//                style = AppResources.typography.body.body1
//            )
//
//        }
//        Image(
//            imageVector = ImageVector.vectorResource(id = R.drawable.girl),
//            contentDescription = null,
//            modifier = Modifier
//                .padding(start = 74.dp)
//        )
        }
    }
}