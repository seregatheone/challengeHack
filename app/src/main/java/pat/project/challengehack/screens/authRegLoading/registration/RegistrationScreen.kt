package pat.project.challengehack.screens.authRegLoading.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
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
import basic.domain.auth.models.registration.GenderEntityRegistration
import core.ui.components.buttons.filled.FilledColorRoundedButton
import core.ui.components.buttons.iconButton.CustomIconButton
import core.ui.components.buttons.iconButton.IconButtonStyles
import core.ui.components.inputComponents.inputComponent.InputComponent
import core.ui.themes.AppResources
import pat.project.challengehack.screens.authRegLoading.registration.models.RegistrationNavDestinations
import pat.project.challengehack.R

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    viewModel: RegistrationViewModel = hiltViewModel(),
    onclickBack: () -> Unit,
    navigateToMainWithPopBackStack: () -> Unit,
) {
    val registrationUiState by viewModel.registrationUiState.collectAsState()
    val registrationNavDestinations by viewModel.registrationNavDestination.collectAsState()

    LaunchedEffect(key1 = registrationNavDestinations) {
        when (registrationNavDestinations) {
            RegistrationNavDestinations.MAIN -> navigateToMainWithPopBackStack()
            RegistrationNavDestinations.DEFAULT -> {}
        }
    }



    Column(
        modifier = modifier
            .background(AppResources.colors.Black)
            .statusBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
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
                text = stringResource(id = R.string.registration),
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
                    .padding(bottom = 15.dp, end = 27.dp)
            )

            Text(
                text = stringResource(id = R.string.login),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth(),
                color = AppResources.colors.White
            )
            InputComponent(
                value = registrationUiState.registrationEntity.username,
                onValueChange = { viewModel.changeUsername(it) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                placeholder = stringResource(id = R.string.enter_login),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            Text(
                text = stringResource(id = R.string.email),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                color = AppResources.colors.White
            )
            InputComponent(
                value = registrationUiState.registrationEntity.email,
                onValueChange = { viewModel.changeEmail(it) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                isValid = registrationUiState.isEmailValid,
                placeholder = stringResource(id = R.string.email),
                modifier = Modifier
                    .fillMaxWidth()

            )

            Text(
                text = stringResource(id = R.string.login),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                color = AppResources.colors.White
            )
            InputComponent(
                value = registrationUiState.registrationEntity.password,
                onValueChange = { viewModel.changePassword(it) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                placeholder = stringResource(id = R.string.password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                isValid = registrationUiState.isPasswordValid,
                visualTransformation = PasswordVisualTransformation()
            )


            FilledColorRoundedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 44.dp),
                onClick = { viewModel.registerUser() },
                text = stringResource(id = R.string.registration),
                cornersRadius = 8.dp,
            )

        }

    }
}