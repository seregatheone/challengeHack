package pat.project.challengehack.screens.authRegLoading.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import core.ui.components.buttons.filled.FilledColorRoundedButton
import core.ui.components.buttons.iconButton.CustomIconButton
import core.ui.components.buttons.iconButton.IconButtonStyles
import core.ui.components.inputComponents.inputComponent.InputComponent
import core.ui.themes.AppResources
import pat.project.challengehack.screens.authRegLoading.auth.models.AuthorizationNavDestinations
import pat.project.challengehack.R

@Composable
fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthorizationViewModel = hiltViewModel(),
    onclickBack: () -> Unit,
    onclickReg: () -> Unit,
    navigateToMainWithPopBackStack: () -> Unit,
) {
    val authorizationUiState by viewModel.authorizationUiState.collectAsState()

    val authorizationNavDestinations by viewModel.authorizationNavDestinations.collectAsState()

    LaunchedEffect(key1 = authorizationNavDestinations) {
        when (authorizationNavDestinations) {
            AuthorizationNavDestinations.MAIN -> navigateToMainWithPopBackStack()
            AuthorizationNavDestinations.DEFAULT -> {}
        }
    }
    Column(
        modifier = modifier
            .background(AppResources.colors.Black)
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()
            .imePadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .padding(top = 25.dp)
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
            Text(
                text = stringResource(id = R.string.enter),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                color = AppResources.colors.White,
                style = AppResources.typography.headlines.headline0
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 100.dp)
                .padding(horizontal = 10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                tint = AppResources.colors.White,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 50.dp, end = 27.dp)
            )
            Text(
                text = stringResource(id = R.string.login),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth(),
                color = AppResources.colors.White
            )
            InputComponent(
                value = authorizationUiState.loginEntity.username,
                onValueChange = { viewModel.changeUsername(it) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                placeholder = stringResource(id = R.string.login),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = R.string.password),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                color = AppResources.colors.White
            )
            InputComponent(
                value = authorizationUiState.loginEntity.password,
                onValueChange = { viewModel.changePassword(it) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                placeholder = stringResource(id = R.string.password),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            FilledColorRoundedButton(
                modifier = Modifier
                    .padding(top = 44.dp)
                    .fillMaxWidth(),
                onClick = {
                    viewModel.login()
                },
                text = stringResource(id = R.string.enter_ready),
                cornersRadius = 8.dp
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = stringResource(id = R.string.enter_with),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth(),
                color = AppResources.colors.Grey90
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.basil_vk_outline), contentDescription = null,
                        tint = AppResources.colors.White)
                }
            }

        }
    }
}

