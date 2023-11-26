package pat.project.challengehack.screens.rooms.roomScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import pat.project.challengehack.R


@Composable
fun ParticipantImageAndName(
    modifier: Modifier = Modifier,
    isOwner: Boolean,
    username: String,
    userPhotoUrl: String
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .size(52.dp)
                .clip(shape = CircleShape)
                .background(AppResources.colors.White)
                .border(width = if (isOwner) 1.dp else 0.dp, color = AppResources.colors.White),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(userPhotoUrl)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = if(isOwner) stringResource(id = R.string.i_am_the_leader) else username,
            style = AppResources.typography.body.body1
        )
    }

}