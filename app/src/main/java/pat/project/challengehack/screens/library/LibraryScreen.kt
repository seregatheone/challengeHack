package pat.project.challengehack.screens.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LibraryScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .statusBarsPadding()
        .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Library", color = Color.White)
    }
}