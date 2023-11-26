package pat.project.challengehack.screens.genre

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
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
    onclickBack: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getGenreMusicByName(genreName)
        viewModel.getGenreInfo(genreName)
    }

    val genreUiState by viewModel.genreUiState.collectAsState()

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .background(
                        color = AppResources.colors.Grey60,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .size(170.dp),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(genreUiState.genreInfo?.pictureUrl)
                    .decoderFactory(SvgDecoder.Factory())
                    .memoryCachePolicy(policy = CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = null
            )
            LazyColumn(
                modifier = Modifier
                    .padding(top = 22.dp)
                    .fillMaxHeight()
            ) {
                items(genreUiState.soundList) { item ->
                    TrackItem(item = item, modifier = Modifier)
                }
            }
        }
    }
}

