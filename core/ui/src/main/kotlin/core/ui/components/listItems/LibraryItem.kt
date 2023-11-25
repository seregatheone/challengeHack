package core.ui.components.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import basic.domain.library.models.LibraryEntity
import basic.domain.main.models.GenreEntity
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import core.ui.themes.AppResources
import pat.project.challengehack.core.ui.R

@Composable
fun LibraryItem(
    modifier: Modifier = Modifier,
    item: LibraryEntity,
) {
    Row(
        modifier = modifier
            .padding(top = 8.dp)
            .background(color = AppResources.colors.Grey90_60,
                shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = modifier
                    .padding(bottom = 4.dp)
                    .background(
                        color = AppResources.colors.Grey80,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .size(60.dp),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.pictureUrl)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = item.artistName, color = AppResources.colors.White,
                    style = AppResources.typography.body.body1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                )
                Text(
                    text = item.songName, color = AppResources.colors.White,
                    style = AppResources.typography.titles.title0,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.DeleteOutline, contentDescription = null,
                tint = AppResources.colors.White,
                modifier = Modifier
                    .size(35.dp))
        }
    }
}