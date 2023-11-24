package core.ui.components.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import core.ui.themes.AppResources
import pat.project.challengehack.core.ui.R

@Composable
fun FriendItem(
    modifier: Modifier = Modifier,
    //friendEntity: FriendEntity,
    navigateToChat : () -> Unit,
    navigateToCall: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(vertical = 9.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            modifier = Modifier
        ) {

//            AsyncImage(
//                modifier = Modifier
//                    .size(54.dp)
//                    .clip(shape = CircleShape)
//                    .background(color = AppResources.colors.White70, shape = CircleShape),
//                contentScale = ContentScale.Crop,
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(friendEntity.profilePictureUrl)
//                    .decoderFactory(SvgDecoder.Factory())
//                    .build(),
//                contentDescription = null
//            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
//                Text(
//                    text = friendEntity.username,
//                    style = AppResources.typography.body.body0,
//                    color = AppResources.colors.White
//                )
//                Text(
//                    text = (stringResource(id = R.string.user_id, friendEntity.userId.toString())),
//                    style = AppResources.typography.body.body1,
//                    color = AppResources.colors.White70
//                )
            }
        }
        Row(
            modifier = Modifier
        ) {
            IconButton(onClick = navigateToCall) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null
                )
            }
            IconButton(onClick = navigateToChat) {
                Icon(
                    imageVector = Icons.Default.Message,
                    contentDescription = null
                )
            }
        }
    }
}


