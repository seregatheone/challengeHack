package core.ui.components.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import basic.domain.main.models.GenreEntity
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest
import core.ui.themes.AppResources

@Composable
fun GenreItem(
    modifier: Modifier = Modifier,
    item: GenreEntity,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(end = 8.dp)
            .size(170.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor =  AppResources.colors.Grey90),
        shape = RoundedCornerShape(8.dp)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.pictureUrl)
                .decoderFactory(SvgDecoder.Factory())
                .memoryCachePolicy(policy = CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = null
        )
    }
}