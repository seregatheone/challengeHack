package pat.project.challengehack.screens.authRegLoading.welcomepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WelcomePageScreen(
    modifier: Modifier = Modifier,
    viewModel: WelcomePageViewModel = hiltViewModel(),
    navigateToAuthorization : () -> Unit,
    navigateToRegistration : () -> Unit,
) {
    Column(
        modifier = modifier
//            .background(AppResources.colors.LightPurple)
            .statusBarsPadding()
            .padding(top = 220.dp),
//            .paint(painterResource(id = R.drawable.welcome_page_notes),
//                contentScale = ContentScale.FillWidth),
        verticalArrangement = Arrangement.Bottom

    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.welcome_page_logo),
//                contentDescription = null)
//            FilledColorRoundedButton(
//                modifier = Modifier
//                    .padding(top = 32.dp),
//                onClick = navigateToAuthorization,
//                text = stringResource(id = R.string.login)
//            )
//            OutlinedRoundedButton(
//                modifier = Modifier
//                    .padding(top = 24.dp),
//                onClick = navigateToRegistration,
//                text = stringResource(id = R.string.signup)
//            )
        }
//        Image(
//            modifier = Modifier
//                .padding(top = 80.dp),
//            painter = painterResource(id = R.drawable.man_w_mic),
//            contentDescription = null
//        )
    }
}