package pat.project.challengehack.screens.main.mainScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
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


@Composable
fun ServerItem(
    modifier: Modifier,
//    serverEntity: ServerEntity,
    navigateToServer: () -> Unit,
) {
//    Row(
//        modifier = modifier
//            .padding(vertical = 9.dp)
//            .clickable(indication = null,
//                interactionSource = MutableInteractionSource(),
//                onClick = navigateToServer),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//
//    ) {
//        Row(
//            modifier = Modifier
//                .clickable(indication = null,
//                interactionSource = MutableInteractionSource(),
//                onClick = navigateToServer),
//        ) {
//
//            AsyncImage(
//                modifier = Modifier
//                    .size(54.dp)
//                    .clip(shape = CircleShape)
//                    .background(color = AppResources.colors.White70, shape = CircleShape),
//                contentScale = ContentScale.Crop,
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(serverEntity.serverPictureUrl)
//                    .decoderFactory(SvgDecoder.Factory())
//                    .build(),
//                contentDescription = null
//            )
//            Column(
//                modifier = Modifier
//                    .padding(start = 16.dp)
//            ) {
//                Text(
//                    text = serverEntity.servername,
//                    style = AppResources.typography.body.body0,
//                    color = AppResources.colors.White
//                )
//                Text(
//                    text = (stringResource(
//                        id = R.string.user_id,
//                        serverEntity.serverId.toString()
//                    )),
//                    style = AppResources.typography.body.body1,
//                    color = AppResources.colors.White70
//                )
//            }
//        }
//
//            IconButton(onClick = {}) {
//                Icon(
//                    imageVector = Icons.Default.ArrowForwardIos,
//                    contentDescription = null
//                )
//            }
//
//        }

}