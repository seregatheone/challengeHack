package core.ui.components.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
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
import core.ui.components.buttons.filled.FilledButtonStyles
import core.ui.components.buttons.filled.FilledColorSmallRoundedButton
import core.ui.components.buttons.outlined.OutlinedSmallRoundedButton
import core.ui.themes.AppResources
import pat.project.challengehack.core.ui.R
@Composable
fun FriendRequestItem(
    modifier: Modifier,
    //friendEntity: FriendRequestEntity,
    onAcceptRequest : (Int) -> Unit,
    onDeclineRequest : (Int) -> Unit,
) {
    Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
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
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Имя пользователя",//friendEntity.username,
                    style = AppResources.typography.body.body0,
                    color = AppResources.colors.White
                )
//                Text(
//                    text = (stringResource(id = R.string.user_id, friendEntity.userId.toString())),
//                    style = AppResources.typography.body.body1,
//                    color = AppResources.colors.White70,
//                    modifier = Modifier
//                        .padding(top = 8.dp)
//                )
            }
        }
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
//            FilledColorSmallRoundedButton(
//                modifier = Modifier.padding(top = 6.dp),
//                onClick = { onAcceptRequest(friendEntity.userId) } ,
//                buttonStyle = FilledButtonStyles.YELLOW,
//                text = stringResource(id = R.string.friends_request_accept_button),
//            )
//            OutlinedSmallRoundedButton(
//                modifier = Modifier.padding(bottom = 6.dp),
//                onClick = { onDeclineRequest(friendEntity.userId) } ,
//                text = stringResource(id = R.string.friends_request_decline_button),
//            )
        }
    }
}