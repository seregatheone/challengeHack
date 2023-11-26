package pat.project.challengehack.screens.main.mainScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.items
import core.ui.components.listItems.GenreItem
import core.ui.components.listItems.RelizeItem
import core.ui.components.listItems.TransItem
import core.ui.themes.AppResources
import pat.project.challengehack.R


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel(),
    navigateToFriendsListWithPopBack: () -> Unit,
    navigateToGenre : (String) -> Unit,
    navigateToRelease : (Int) -> Unit
) {

    val mainUiState by viewModel.mainUiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getReleaseList()
        viewModel.getGenreList()
    }

    Scaffold(modifier = Modifier,
        topBar = {
            Row(modifier = Modifier
                .background(color = AppResources.colors.Black)
                .statusBarsPadding()
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                Icon(painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 4.dp),
                    tint = AppResources.colors.White,
                )
            }
        }) { padding ->
        Column(
            modifier = modifier
                .background(color = AppResources.colors.Black)
                .padding(top = 22.dp, start = 22.dp)
                .padding(top = padding.calculateTopPadding()),
        ) {
            Text(text = stringResource(id = R.string.genre),
                color = AppResources.colors.White,
                style = AppResources.typography.headlines.headline1)
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(top  =12.dp)){
                items(mainUiState.genreList){
                    item ->
                    GenreItem(item = item,
                        onClick = {
                            navigateToGenre(item.genre)
                        })
                }
            }

            Text(text = stringResource(id = R.string.last_rel),
                color = AppResources.colors.White,
                style = AppResources.typography.headlines.headline1,
                modifier = Modifier
                    .padding(top  =18.dp))
            LazyRow(modifier = Modifier
                .padding(top  =12.dp)){
                items(mainUiState.relizeList){
                        item ->
                    RelizeItem(item = item,
                        onClick = {
                            navigateToRelease(item.albumId)
                        })
                }
            }

            Text(text = stringResource(id = R.string.trans),
                color = AppResources.colors.White,
                style = AppResources.typography.headlines.headline1,
                modifier = Modifier
                    .padding(top  =18.dp))
            LazyRow(modifier = Modifier
                .padding(top  =12.dp)){
                items(mainUiState.transList){
                        item ->
                    TransItem(item = item,
                        onClick = {})
                }
            }
        }
    }
}
