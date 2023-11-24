package pat.project.challengehack.screens.authRegLoading.registration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import pat.project.challengehack.screens.authRegLoading.registration.models.RegistrationNavDestinations

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    viewModel: RegistrationViewModel = hiltViewModel(),
    onclickBack: () -> Unit,
    navigateToMainWithPopBackStack: () -> Unit,
    onclickLogIn: () -> Unit,
) {
//    val registrationUiState by viewModel.registrationUiState.collectAsState()
//    val registrationNavDestinations by viewModel.registrationNavDestination.collectAsState()
//
//    LaunchedEffect(key1 = registrationNavDestinations) {
//        when (registrationNavDestinations) {
//            RegistrationNavDestinations.MAIN -> navigateToMainWithPopBackStack()
//            RegistrationNavDestinations.DEFAULT -> {}
//        }
//    }
//
//    Box(
//        modifier = modifier
//            .imePadding()
//            .verticalScroll(rememberScrollState())
//    ) {
//        Column(
//            modifier = modifier
//                .background(AppResources.colors.LightPurple)
//                .paint(
//                    painterResource(id = R.drawable.welcome_page_notes),
//                    contentScale = ContentScale.FillWidth
//                )
//                .statusBarsPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Image(
//                modifier = Modifier.padding(top = 120.dp),
//                painter = painterResource(id = R.drawable.welcome_page_logo),
//                contentDescription = null
//            )
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 30.dp, start = 6.dp, end = 6.dp)
//            ) {
//                Column(
//                    modifier = Modifier.padding(vertical = 24.dp, horizontal = 10.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//
//                ) {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
////                    horizontalArrangement = Arrangement.SpaceEvenly
//                    ) {
//                        CustomIconButton(
//                            iconButtonStyle = IconButtonStyles.ARROW_BACK,
//                            onCLick = onclickBack
//                        )
//                        Text(
//                            text = stringResource(id = R.string.create_acc),
//                            style = AppResources.typography.headlines.headline0,
//                            color = AppResources.colors.White,
//                            modifier = Modifier.padding(start = 26.dp)
//                        )
//
//                    }
//                    Spacer(modifier = Modifier.padding(top = 40.dp))
//
//                    InputComponent(
//                        value = registrationUiState.registrationEntity.email,
//                        onValueChange = { viewModel.changeEmail(it) },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            keyboardType = KeyboardType.Email,
//                            imeAction = ImeAction.Next
//                        ),
//                        isValid = registrationUiState.isEmailValid,
//                        placeholder = stringResource(id = R.string.email),
//                        modifier = Modifier
//                            .fillMaxWidth()
//
//                    )
//
//                    InputComponent(
//                        value = registrationUiState.registrationEntity.username,
//                        onValueChange = { viewModel.changeUsername(it) },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            keyboardType = KeyboardType.Text,
//                            imeAction = ImeAction.Next
//                        ),
//                        placeholder = stringResource(id = R.string.username),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 18.dp)
//                    )
//
//
//                    CustomDropDownMenu(
//                        items = arrayListOf(
//                            GenderEntityRegistration.MALE.genderName,
//                            GenderEntityRegistration.FEMALE.genderName
//                        ),
//                        onItemSelected = { viewModel.changeGender(it.getGenderEntityByName()) },
//                        selectedItem = registrationUiState.registrationEntity.gender.genderName,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 18.dp)
//                    )
//
//                    InputComponent(
//                        value = registrationUiState.registrationEntity.password,
//                        onValueChange = { viewModel.changePassword(it) },
//                        keyboardOptions = KeyboardOptions.Default.copy(
//                            keyboardType = KeyboardType.Password,
//                            imeAction = ImeAction.Done
//                        ),
//                        placeholder = stringResource(id = R.string.password),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 18.dp),
//                        isValid = registrationUiState.isPasswordValid,
//                        visualTransformation = PasswordVisualTransformation()
//                    )
//
//
//                    FilledColorRoundedButton(
//                        modifier = Modifier
//                            .padding(top = 32.dp),
//                        onClick = { viewModel.registerUser() },
//                        text = stringResource(id = R.string.sign_up)
//                    )
//                    Row(
//                        modifier = Modifier
//                            .padding(top = 18.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = stringResource(id = R.string.already),
//                            style = AppResources.typography.titles.title1,
//                            color = AppResources.colors.White
//                        )
//                        Text(
//                            text = stringResource(id = R.string.already_log),
//                            style = AppResources.typography.links.link2.copy(textDecoration = TextDecoration.Underline),
//                            color = AppResources.colors.YellowGold,
//                            modifier = Modifier
//                                .padding(start = 12.dp)
//                                .clickable { onclickLogIn() },
//                        )
//                    }
//
//                }
//            }
//        }
//    }
}