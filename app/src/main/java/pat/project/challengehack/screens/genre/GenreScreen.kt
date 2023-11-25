package pat.project.challengehack.screens.genre

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest
import core.ui.components.listItems.LibraryItem
import core.ui.components.listItems.TrackItem
import core.ui.themes.AppResources
import pat.project.challengehack.R
import pat.project.challengehack.screens.main.mainScreen.MainScreenViewModel

@Composable
fun GenreScreen(
    modifier: Modifier = Modifier,
    viewModel: GenreViewModel = hiltViewModel(),
    genreName: String,
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getGenreMusicByName(genreName)
    }

    val genreUiState by viewModel.genreUiState.collectAsState()

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
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                items(genreUiState.soundList) { item ->
                    TrackItem(item = item, modifier = Modifier)
                }
            }
            Text(text = genreName)
        }
    }
}

