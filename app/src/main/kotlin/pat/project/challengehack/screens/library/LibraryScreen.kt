package pat.project.challengehack.screens.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import core.ui.components.listItems.GenreItem
import core.ui.components.listItems.LibraryItem
import core.ui.themes.AppResources
import pat.project.challengehack.R
import pat.project.challengehack.screens.main.mainScreen.MainScreenViewModel

@Composable
fun LibraryScreen(
    modifier: Modifier = Modifier,
    viewModel: LibraryViewModel = hiltViewModel(),
) {
    val localSoundList = viewModel.localSoundList

    Scaffold(modifier = Modifier,
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
                .background(color = AppResources.colors.Black)
                .padding(top = 22.dp, start = 22.dp)
                .padding(top =  padding.calculateTopPadding()),
        ) {
            LazyColumn(modifier = Modifier
                .fillMaxHeight()){
                items(localSoundList){
                    item ->
                        LibraryItem(item = item, modifier = Modifier)
                }
            }
        }
    }
}