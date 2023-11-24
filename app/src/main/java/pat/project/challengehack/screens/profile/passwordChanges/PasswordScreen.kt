package pat.project.challengehack.screens.profile.passwordChanges

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PasswordScreen(
    modifier: Modifier = Modifier,
    viewModel: PasswordViewModel = hiltViewModel(),
    onClickBack: () -> Unit,
    onSavePassword : () -> Unit
) {
//    val profileInfo by viewModel.profileInfo.collectAsState()
//    val accountUiState by viewModel.accountUiState.collectAsState()

//    val passwordUiState by viewModel.passUiState.collectAsState()
//
//    Column(
//        modifier = modifier
//            .statusBarsPadding()
//            .background(color = AppResources.colors.PurpleGreyMedium)
//            .padding(top = 12.dp),
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(start = 16.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            CustomIconButton(
//                iconButtonStyle = IconButtonStyles.ARROW_BACK,
//                onCLick = { onClickBack() })
//            Text(
//                text = stringResource(id = R.string.acc),
//                color = Color.White,
//                style = AppResources.typography.titles.title0,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .padding(start = 20.dp),
//            )
//        }
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(horizontal = 8.dp)
//                    .padding(top = 27.dp)
//                    .weight(1f),
//            ) {
//                Text(
//                    text = stringResource(id = R.string.old_pass),
//                    style = AppResources.typography.body.body0
//                )
//                InputComponent(
//                    value = passwordUiState.oldPassword,
//                    modifier = Modifier
//                        .background(shape = RoundedCornerShape(6.dp), color = Color.Unspecified)
//                        .padding(top = 2.dp),
//                    backgroundColor = AppResources.colors.PurpleDark,
//                    onValueChange = { viewModel.changeOldPass(it) },
//                    placeholder = stringResource(id = R.string.old_pass)
//                )
//
//                Text(
//                    text = stringResource(id = R.string.new_pass),
//                    style = AppResources.typography.body.body0,
//                    modifier = Modifier
//                        .padding(top = 12.dp)
//                )
//
//                InputComponent(
//                    value = passwordUiState.newPassword,
//                    modifier = Modifier
//                        .background(shape = RoundedCornerShape(6.dp), color = Color.Unspecified)
//                        .padding(top = 2.dp),
//                    backgroundColor = AppResources.colors.PurpleDark,
//                    onValueChange = { viewModel.changeNewPass(it) },
//                    placeholder = stringResource(id = R.string.new_pass)
//                )
//
//                Text(
//                    text = stringResource(id = R.string.repeat_pass),
//                    style = AppResources.typography.body.body0,
//                    modifier = Modifier
//                        .padding(top = 12.dp)
//                )
//
//                InputComponent(
//                    value = passwordUiState.repPassword,
//                    modifier = Modifier
//                        .background(shape = RoundedCornerShape(6.dp), color = Color.Unspecified)
//                        .padding(top = 2.dp),
//                    backgroundColor = AppResources.colors.PurpleDark,
//                    onValueChange = { viewModel.changeRepPass(it) },
//                    placeholder = stringResource(id = R.string.repeat_pass)
//                )
//
//            }
//            FilledColorRoundedButton(
//                onClick = {
////                    viewModel.updatePassword()
//                    onSavePassword()
//                },
//                text = stringResource(id = R.string.save),
//                modifier = Modifier
//                    .padding(bottom = 10.dp),
//                width = 380.dp,
//                height = 60.dp,
//                cornersRadius = 12.dp,
//                buttonStyle = FilledButtonStyles.PURPLE_LIGHT,
//            )
//        }
//
//    }
}