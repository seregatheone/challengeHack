package pat.project.challengehack.screens.friends.friendsScreen.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun FriendsRequestCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @StringRes
    text : Int
){
//    Row(
//        modifier = modifier
//            .clickable { onClick() },
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Icon(imageVector = ImageVector.vectorResource(R.drawable.requests__2_), contentDescription = null)
//        Row(
//            modifier= Modifier
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(text = stringResource(id = text), style = AppResources.typography.titles.title1, color = AppResources.colors.YellowGold,
//                modifier = Modifier
//                    .padding(start = 12.dp))
//            IconButton(onClick = { /*TODO*/ },
//                modifier = Modifier
//                    .padding(end = 15.dp)
//                    .background(color = AppResources.colors.LightPurple, shape = CircleShape)
//                    .height(30.dp)
//                    .width(30.dp)) {
//                Text(text = "")
//            }
//        }
//
//    }
}