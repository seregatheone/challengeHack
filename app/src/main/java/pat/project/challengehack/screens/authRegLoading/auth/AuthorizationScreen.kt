package pat.project.challengehack.screens.authRegLoading.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthorizationViewModel = hiltViewModel(),
    onclickBack: () -> Unit,
    onclickReg: () -> Unit,
    navigateToMainWithPopBackStack: () -> Unit,
) {
//    val authorizationUiState by viewModel.authorizationUiState.collectAsState()
//
//    val authorizationNavDestinations by viewModel.authorizationNavDestinations.collectAsState()
//
//    LaunchedEffect(key1 = authorizationNavDestinations) {
//        when (authorizationNavDestinations) {
//            AuthorizationNavDestinations.MAIN -> navigateToMainWithPopBackStack()
//            AuthorizationNavDestinations.DEFAULT -> {}
//        }
//    }
//
//    Column(
//        modifier = modifier
//            .background(AppResources.colors.LightPurple)
//            .statusBarsPadding()
//            .padding(top = 120.dp)
//            .paint(
//                painterResource(id = R.drawable.welcome_page_notes),
//                contentScale = ContentScale.FillWidth
//            )
//            .imePadding()
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.welcome_page_logo),
//            contentDescription = null
//        )
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 30.dp, start = 6.dp, end = 6.dp)
//        ) {
//            Column(
//                modifier = Modifier.padding(vertical = 24.dp, horizontal = 10.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//
//            ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                ) {
//                    CustomIconButton(
//                        iconButtonStyle = IconButtonStyles.ARROW_BACK,
//                        onCLick = onclickBack
//                    )
//                    Text(
//                        text = stringResource(id = R.string.wel_back),
//                        style = AppResources.typography.headlines.headline0,
//                        color = AppResources.colors.White,
//                        modifier = Modifier.padding(start = 26.dp)
//                    )
//
//                }
//                Spacer(modifier = Modifier.padding(top = 40.dp))
//
//                InputComponent(
//                    value = authorizationUiState.loginEntity.username,
//                    onValueChange = { viewModel.changeUsername(it) },
//                    keyboardOptions = KeyboardOptions.Default.copy(
//                        keyboardType = KeyboardType.Text,
//                        imeAction = ImeAction.Next
//                    ),
//                    placeholder = stringResource(id = R.string.username),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                )
//
//                InputComponent(
//                    value = authorizationUiState.loginEntity.password,
//                    onValueChange = { viewModel.changePassword(it) },
//                    keyboardOptions = KeyboardOptions.Default.copy(
//                        keyboardType = KeyboardType.Password,
//                        imeAction = ImeAction.Done
//                    ),
//                    placeholder = stringResource(id = R.string.password),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 18.dp),
//                    visualTransformation = PasswordVisualTransformation()
//                )
//
//
//                FilledColorRoundedButton(
//                    modifier = Modifier
//                        .padding(top = 32.dp),
//                    onClick = {
//                        viewModel.login()
//                    },
//                    text = stringResource(id = R.string.log_in)
//                )
//                Row(
//                    modifier = Modifier
//                        .padding(top = 18.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.no_acc),
//                        style = AppResources.typography.titles.title1,
//                        color = AppResources.colors.White
//                    )
//                    Text(
//                        text = stringResource(id = R.string.link_singup),
//                        style = AppResources.typography.links.link2.copy(textDecoration = TextDecoration.Underline),
//                        color = AppResources.colors.YellowGold,
//                        modifier = Modifier
//                            .padding(start = 12.dp)
//                            .clickable { onclickReg() },
//                    )
//                }
//
//            }
//        }
//    }
}