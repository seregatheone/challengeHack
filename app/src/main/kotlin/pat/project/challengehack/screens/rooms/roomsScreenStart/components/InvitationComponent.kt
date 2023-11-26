package pat.project.challengehack.screens.rooms.roomsScreenStart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import basic.domain.room.models.RoomsInvitationEntity
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import core.ui.themes.AppResources
import pat.project.challengehack.R


@Composable
fun InvitationComponent(
    modifier: Modifier = Modifier,
    invitationEntity: RoomsInvitationEntity,
    acceptInvitation: () -> Unit,
    declineInvitation: () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppResources.colors.Grey90_60
        )
    ) {

        Column {
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 8.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(shape = CircleShape)
                        .background(AppResources.colors.White),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(invitationEntity.userPictureUrl)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Text(
                        style = AppResources.typography.titles.title0,
                        text = invitationEntity.userName,
                        color = AppResources.colors.White
                    )

                    Text(
                        style = AppResources.typography.titles.title1,
                        text = invitationEntity.userName,
                        color = AppResources.colors.White
                    )

//                    with(invitationEntity.roomData.nowPlaying) {
//                        Text(
//                            modifier = Modifier.padding(top = 4.dp),
//                            text = buildAnnotationStringWithSong("$trackAuthor $trackName")
//                        )
//                    }


                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = AppResources.colors.Grey90_60
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = stringResource(id = R.string.decline_invitation),
                    style = AppResources.typography.titles.title1,
                    color = AppResources.colors.White
                )
                Spacer(
                    modifier = Modifier
                        .height(32.dp)
                        .width(1.dp)
                        .background(AppResources.colors.Grey90_60),
                )
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = stringResource(id = R.string.accept_invitation),
                    style = AppResources.typography.titles.title1,
                    color = AppResources.colors.White
                )
            }

        }

    }
}