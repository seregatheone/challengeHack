package pat.project.challengehack.screens.album

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
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
    onclickBack: () -> Unit
){
    LaunchedEffect(key1 = Unit) {
        viewModel.getAlbumMusicById(albumId)
    }

    val albumUiState by viewModel.albumUiState.collectAsState()

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .background(AppResources.colors.Black)
                    .fillMaxWidth(),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.charm_arrow_up__1_),
                    contentDescription = null,
                    tint = AppResources.colors.White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable { onclickBack() }
                        .padding(start = 20.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center),
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