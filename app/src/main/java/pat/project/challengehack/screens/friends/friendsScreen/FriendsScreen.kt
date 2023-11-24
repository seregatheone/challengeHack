package pat.project.challengehack.screens.friends.friendsScreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FriendsScreen(
    modifier: Modifier = Modifier,
    viewModel: FriendsScreenViewModel = hiltViewModel(),
    navigateToFriendsRequest: () -> Unit,
    navigateToChat: (chatId : Int) -> Unit,
    navigateToCall : (userId : Int) -> Unit
) {
//    val friendList = viewModel.friendList.collectAsLazyPagingItems()
//    val friendsNavDirections by viewModel.friendsNavDirections.collectAsState()
//
//    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
//    var isFocused: Boolean by remember {
//        mutableStateOf(false)
//    }
//    val scope = rememberCoroutineScope()
//    var searchValue: String by remember {
//        mutableStateOf("")
//    }
//
//    LaunchedEffect(key1 = friendsNavDirections){
//        when(friendsNavDirections){
//            FriendsNavDirections.Default -> {}
//            is FriendsNavDirections.FriendRequests ->{
//                navigateToFriendsRequest()
//            }
//            is FriendsNavDirections.Call -> {
//                navigateToCall((friendsNavDirections as FriendsNavDirections.Call).userId)
//                viewModel.clearNavDirections()
//            }
//            is FriendsNavDirections.Chat -> {
//                navigateToChat((friendsNavDirections as FriendsNavDirections.Chat).chatId)
//                viewModel.clearNavDirections()
//            }
//        }
//    }
//
//    ModalBottomSheetLayout(
//        sheetState = sheetState,
//        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
//        sheetBackgroundColor = AppResources.colors.PurpleDark,
//        modifier = modifier
//            .fillMaxSize()
//            .background(color = AppResources.colors.PurpleDark),
//        sheetContent = {
//            Column(
//                modifier = Modifier
//                    .padding(top = 48.dp)
//                    .imePadding()
//                    .padding(horizontal = 15.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = stringResource(id = R.string.bottom_sheet_title),
//                    style = AppResources.typography.headlines.headline2,
//                    color = AppResources.colors.White
//                )
//                Text(
//                    text = stringResource(id = R.string.bottom_sheet_text),
//                    style = AppResources.typography.body.body0,
//                    color = AppResources.colors.White70,
//                    modifier = Modifier
//                        .padding(top = 12.dp)
//                )
//                BasicTextField(value = searchValue,
//                    onValueChange = { searchValue = it },
//                    singleLine = true,
//                    textStyle = AppResources.typography.titles.title1.copy(color = AppResources.colors.White),
//                    modifier = Modifier
//                        .padding(top = 24.dp)
//                        .background(
//                            color = AppResources.colors.PurpleGreyDark,
//                            shape = RoundedCornerShape(12.dp)
//                        )
//                        .onFocusChanged { focusState ->
//                            isFocused = focusState.isFocused
//                        }
//                        .padding(start = 15.dp, end = 15.dp, top = 9.dp, bottom = 9.dp)
//                        .fillMaxWidth(),
//                    decorationBox = { innerTextBox ->
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.Search,
//                                contentDescription = null,
//                                tint = AppResources.colors.White70
//                            )
//                            if (!isFocused && searchValue.isEmpty()) {
//                                Text(
//                                    modifier = Modifier
//                                        .background(Color.Unspecified),
//                                    text = stringResource(id = R.string.enter_username),
//                                    style = AppResources.typography.titles.title1.copy(color = AppResources.colors.White),
//                                )
//                            } else {
//                                innerTextBox()
//                            }
//                        }
//                    })
//                Button(
//                    onClick = {
//                        if (searchValue.isDigitsOnly()) {
//                            viewModel.sendFriendRequest(
//                                searchValue.toInt()
//                            )
//                        } else {
//                            // ОШИБКА
//                        }
//
//                    },
//                    modifier = Modifier
//                        .padding(top = 18.dp)
//                        .fillMaxWidth(),
//                    colors = ButtonDefaults.buttonColors(backgroundColor = AppResources.colors.YellowGold),
//                    shape = RoundedCornerShape(12.dp)
//                )
//                {
//                    Text(
//                        modifier = Modifier,
//                        text = stringResource(id = R.string.bottom_sheet_text_button),
//                        style = AppResources.typography.titles.title1,
//                        color = AppResources.colors.PurpleDark,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//
//                Text(
//                    modifier = Modifier
//                        .padding(top = 24.dp),
//                    text = stringResource(id = R.string.bottom_sheet_options),
//                    style = AppResources.typography.titles.title1,
//                    color = AppResources.colors.White,
//                )
//                ClickableCardTextWithIcon(
//                    modifier = Modifier
//                        .padding(top = 24.dp, bottom = 24.dp),
//                    text = R.string.bottom_sheet_sync_contact,
//                    icon = IconButtonStyles.SYNC,
//                    onClick = {},
//                    color = AppResources.colors.PurpleDarkOnCLick
//                )
//            }
//
//        }
//    ) {
//        Scaffold(modifier = Modifier
//            .statusBarsPadding()
//            .fillMaxSize(),
//            topBar = {
//                Box(
//                    modifier = Modifier
//                        .background(color = AppResources.colors.SystemHeader)
//                        .fillMaxWidth()
//                        .height(62.dp)
//                        .padding(end = 18.dp)
//
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.title_friends),
//                        style = AppResources.typography.titles.title0,
//                        modifier = Modifier.align(Alignment.Center)
//                    )
//                    CustomIconButton(
//                        iconButtonStyle = IconButtonStyles.GROUP_ADD,
//                        onCLick = {
//                            scope.launch {
//                                sheetState.show()
//                            }
//                        },
//                        modifier = Modifier.align(Alignment.CenterEnd)
//                    )
//                }
//            }) { padding ->
//            if (friendList.itemCount == 0) {
////                                  Поправить на 0
//                Column(
//                    modifier = Modifier
//                        .padding(top = padding.calculateTopPadding())
//                        .background(color = AppResources.colors.PurpleSemiDark)
//                        .paint(
//                            painterResource(id = R.drawable.welcome_page_notes),
//                            contentScale = ContentScale.FillWidth,
//                            colorFilter = ColorFilter.tint(AppResources.colors.PurpleGreyMedium)
//                        )
//                        .padding(top = 150.dp)
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//
//                    Text(
//                        text = stringResource(id = R.string.none_friends_title),
//                        style = AppResources.typography.headlines.headline0,
//                        color = AppResources.colors.YellowGold,
//                        modifier = Modifier
//                            .padding(horizontal = 45.dp),
//                        textAlign = TextAlign.Center
//                    )
//                    Text(
//                        text = stringResource(id = R.string.none_friends_text),
//                        style = AppResources.typography.body.body0,
//                        color = AppResources.colors.White70,
//                        modifier = Modifier
//                            .padding(horizontal = 45.dp)
//                            .padding(top = 8.dp),
//                        textAlign = TextAlign.Center
//                    )
//                    ClickableCardTextWithIcon(
//                        modifier = Modifier
//                            .padding(horizontal = 16.dp)
//                            .padding(top = 24.dp),
//                        text = R.string.find_friends,
//                        icon = IconButtonStyles.GROUP_ADD,
//                        onClick = {
//                            scope.launch {
//                                sheetState.show()
//                            }
//                        }
//                    )
//                    Text(
//                        text = stringResource(id = R.string.or_try),
//                        style = AppResources.typography.body.body0,
//                        color = AppResources.colors.White,
//                        modifier = Modifier
//                            .padding(top = 12.dp)
//                    )
//                    BlindTalksComponent(
//                        modifier = Modifier
//                            .padding(horizontal = 16.dp)
//                            .padding(top = 12.dp)
//                    )
//                }
//            } else {
//                Column(
//                    modifier = Modifier
//                        .background(color = AppResources.colors.PurpleSemiDark)
//                        .padding(top = padding.calculateTopPadding())
//                        .padding(horizontal = 16.dp)
//                        .fillMaxSize()
//                ) {
//
//                    FriendsRequestCard(
//                        modifier = Modifier
//                            .padding(top = 24.dp)
//                            .background(
//                                color = AppResources.colors.DarkPurple,
//                                shape = RoundedCornerShape(8.dp)
//                            )
//                            .padding(vertical = 8.dp)
//                            .padding(horizontal = 16.dp)
//                            .fillMaxWidth(),
//                        onClick = viewModel::navigateToFriendsRequests,
//                        text = R.string.friends_request
//                    )
//
//                    BlindTalksComponent(
//                        modifier = Modifier
//                            .padding(top = 24.dp)
//                    )
//
//                    LazyColumn(
//                        modifier = Modifier
//                            .padding(horizontal = 16.dp)
//                            .padding(top = 24.dp)
//                            .fillMaxSize()
//                    ) {
//                        itemsIndexed(friendList) { index, item ->
//                            item?.let {
//                                FriendItem(
//                                    friendEntity = it,
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .height(72.dp),
//                                    navigateToChat = {
//                                        viewModel.checkOrCreateDirectChat(
//                                            it.username
//                                        )
//                                    },
//                                    navigateToCall = {
//                                        viewModel.navigateToCall(
//                                            it.userId
//                                        )
//                                    }
//                                )
//                            }
//
//                            if (index != friendList.itemCount)
//                                Spacer(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .height(1.dp)
//                                        .background(color = AppResources.colors.White70)
//                                )
//                        }
//                    }
//                }
//            }
//        }
//    }
}
