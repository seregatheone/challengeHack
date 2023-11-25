package pat.project.challengehack.screens.authRegLoading.welcomepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import core.ui.components.buttons.filled.FilledButtonStyles
import core.ui.components.buttons.filled.FilledColorRoundedButton
import core.ui.components.buttons.outlined.OutlinedRoundedButton
import core.ui.themes.AppResources
import pat.project.challengehack.R

@Composable
fun WelcomePageScreen(
    modifier: Modifier = Modifier,
    viewModel: WelcomePageViewModel = hiltViewModel(),
    navigateToAuthorization: () -> Unit,
    navigateToRegistration: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(AppResources.colors.Black)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo), contentDescription = null,
            tint = AppResources.colors.White
        )
        Column(
            modifier = Modifier
                .padding(top = 120.dp)
                .padding(horizontal = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            FilledColorRoundedButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = navigateToAuthorization,
                text = stringResource(id = R.string.enter_ready),
                cornersRadius = 8.dp,
                buttonStyle = FilledButtonStyles.MAINRED
            )
            FilledColorRoundedButton(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .fillMaxWidth(),
                onClick = navigateToRegistration,
                text = stringResource(id = R.string.registration),
                cornersRadius = 8.dp,
                buttonStyle = FilledButtonStyles.GREY60
            )
        }
    }
}