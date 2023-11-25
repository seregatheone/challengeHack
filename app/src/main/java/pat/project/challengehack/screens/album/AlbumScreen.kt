package pat.project.challengehack.screens.album

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import core.ui.themes.AppResources
import pat.project.challengehack.R

@Composable
fun AlbumSreen(
    modifier: Modifier = Modifier,
    viewModel: AlbumViewModel = hiltViewModel(),
    albumId: Int,
){
    LaunchedEffect(key1 = Unit) {
        viewModel.getAlbumMusicById(albumId)
    }

    val albumUiState by viewModel.albumUiState.collectAsState()

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .background(color = AppResources.colors.Black)
                    .statusBarsPadding()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 4.dp),
                    tint = AppResources.colors.White,
                )
            }
        }) { padding ->
        Column(
            modifier = modifier
                .fillMaxHeight()
                .background(color = AppResources.colors.Black)
                .padding(top = 22.dp, start = 22.dp),
        ) {
//            AsyncImage(
//                modifier = modifier
//                    .padding(bottom = 4.dp)
//                    .background(
//                        color = AppResources.colors.Grey60,
//                        shape = RoundedCornerShape(4.dp)
//                    )
//                    .size(130.dp),
//                contentScale = ContentScale.Crop,
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(genreUiState.pictureUrl)
//                    .decoderFactory(SvgDecoder.Factory())
//                    .memoryCachePolicy(policy = CachePolicy.ENABLED)
//                    .diskCachePolicy(CachePolicy.ENABLED)
//                    .build(),
//                contentDescription = null
//            )
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxHeight()
//            ) {
//                items(genreUiState.soundList) { item ->
//                    TrackItem(item = item, modifier = Modifier)
//                }
//            }
            Text(text = albumId.toString(), color = Color.White)
        }
    }
}