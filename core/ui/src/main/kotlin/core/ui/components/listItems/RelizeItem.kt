package core.ui.components.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest
import core.ui.themes.AppResources

@Composable
fun RelizeItem(
    modifier: Modifier = Modifier,
    item: RelizeEntity,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(end = 8.dp)
            .width(170.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = AppResources.colors.Grey90),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = modifier
                .background(AppResources.colors.Grey90)
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = modifier
                    .padding(bottom = 4.dp)
                    .background(
                        color = AppResources.colors.Grey60,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .size(130.dp),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.pictureUrl)
                    .decoderFactory(SvgDecoder.Factory())
                    .memoryCachePolicy(policy = CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = null
            )
            Text(
                text = item.name, color = AppResources.colors.White,
                style = AppResources.typography.subTitle.subtitle0,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth()
            )
            Text(
                text = item.bandName, color = AppResources.colors.Grey70,
                style = AppResources.typography.subTitle.subtitle0,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth()
            )

        }

    }
}