package pat.project.challengehack.screens.main.mainScreen


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel(),
    navigateToFriendsListWithPopBack: () -> Unit,
    navigateToChat : (Int) -> Unit,
    navigateToServer : (Int) -> Unit
) {

//    val serversList = viewModel.serverList.collectAsLazyPagingItems()
//    val chatsList = viewModel.directConversationList.collectAsLazyPagingItems()
//
//    val mainNavDirections by viewModel.mainNavDirections.collectAsState()
//
//    LaunchedEffect(key1 = mainNavDirections){
//        when(mainNavDirections){
//            MainNavDirections.Default -> {}
//            MainNavDirections.FriendList -> {
//                navigateToFriendsListWithPopBack()
//                viewModel.clearNavDirections()
//            }
//            is MainNavDirections.Chat -> {
//                navigateToChat((mainNavDirections as MainNavDirections.Chat).chatId)
//                viewModel.clearNavDirections()
//            }
//            is MainNavDirections.Server -> {
//                navigateToServer((mainNavDirections as MainNavDirections.Server).serverId)
//                viewModel.clearNavDirections()
//            }
//        }
//    }
//
//    val showEmptyScreen by remember(chatsList.itemCount, serversList.itemCount) {
//        mutableStateOf(chatsList.itemCount == 0 && serversList.itemCount == 0)
//    }
//
//    val tabsList by remember(chatsList.itemCount, serversList.itemCount) {
//        val finalList = mutableListOf<TabModel>()
//        if (serversList.itemCount != 0) finalList.add(TabModel.ServerTab)
//        if (chatsList.itemCount != 0) finalList.add(TabModel.DirectMessagesTab)
//        mutableStateOf(
//            finalList
//                .sortedBy { it.order }
//                .toList()
//        )
//    }
//
//    var selectedTab by remember(tabsList) {
//        mutableStateOf(
//            tabsList.firstOrNull()
//        )
//    }
//
//    Scaffold(modifier = modifier
//        .statusBarsPadding()
//        .fillMaxSize(),
//        topBar = {
//            if (showEmptyScreen) {
//                Box(
//                    modifier = Modifier
//                        .background(color = AppResources.colors.SystemHeader)
//                        .fillMaxWidth()
//                        .height(62.dp)
//
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.main_screen_title),
//                        style = AppResources.typography.titles.title0,
//                        modifier = Modifier.align(Alignment.Center)
//                    )
//                }
//            } else {
//                selectedTab?.let {
//                    Row(
//                        modifier = Modifier
//                            .background(color = AppResources.colors.SystemHeader)
//                            .fillMaxWidth()
//                            .height(62.dp)
//                            .padding(horizontal = 16.dp),
//                        horizontalArrangement = Arrangement.spacedBy(16.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        tabsList.forEach { tab ->
//
//                            if (tab == selectedTab) {
//                                Text(
//                                    modifier = Modifier
//                                        .clickable(
//                                            interactionSource = MutableInteractionSource(),
//                                            indication = null,
//                                            onClick = { selectedTab = tab }
//                                        ),
//                                    text = stringResource(id = tab.tabName),
//                                    style = AppResources.typography.titles.title0
//                                        .copy(textDecoration = TextDecoration.Underline),
//                                    color = AppResources.colors.White
//                                )
//                            } else {
//                                Text(
//                                    modifier = Modifier
//                                        .clickable(
//                                            interactionSource = MutableInteractionSource(),
//                                            indication = null,
//                                            onClick = { selectedTab = tab }
//                                        ),
//                                    text = stringResource(id = tab.tabName),
//                                    style = AppResources.typography.titles.title1,
//                                    color = AppResources.colors.White70
//                                )
//                            }
//                        }
//
//                    }
//                }
//
//            }
//        }) { padding ->
//        if (showEmptyScreen) {
//            Column(
//                modifier = Modifier
//                    .padding(top = padding.calculateTopPadding())
//                    .background(color = AppResources.colors.PurpleSemiDark)
//                    .paint(
//                        painterResource(id = R.drawable.welcome_page_notes),
//                        contentScale = ContentScale.FillWidth,
//                        colorFilter = ColorFilter.tint(AppResources.colors.PurpleGreyMedium)
//                    )
//                    .padding(top = 150.dp)
//                    .fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = stringResource(id = R.string.main_screen_empty_screen_title),
//                    style = AppResources.typography.headlines.headline0,
//                    color = AppResources.colors.YellowGold,
//                    modifier = Modifier
//                        .padding(horizontal = 45.dp),
//                    textAlign = TextAlign.Center
//                )
//                Text(
//                    text = stringResource(id = R.string.main_screen_empty_screen_description),
//                    style = AppResources.typography.body.body0,
//                    color = AppResources.colors.White70,
//                    modifier = Modifier
//                        .padding(horizontal = 45.dp)
//                        .padding(top = 8.dp),
//                    textAlign = TextAlign.Center
//                )
//                ClickableCardTextWithIcon(
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp)
//                        .padding(top = 24.dp),
//                    text = R.string.navigate_to_friends_list,
//                    icon = IconButtonStyles.GROUP_ADD,
//                    onClick = viewModel::navigateToFriendList
//                )
//                Text(
//                    text = stringResource(id = R.string.or_try),
//                    style = AppResources.typography.body.body0,
//                    color = AppResources.colors.White,
//                    modifier = Modifier
//                        .padding(top = 12.dp)
//                )
//                BlindTalksComponent(
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp)
//                        .padding(top = 12.dp)
//                )
//            }
//        } else {
//            when(selectedTab) {
//                TabModel.DirectMessagesTab -> {
//                    Column(
//                        modifier = Modifier
//                            .background(color = AppResources.colors.PurpleSemiDark)
//                            .padding(top = padding.calculateTopPadding())
//                            .fillMaxSize()
//                    ) {
//                        LazyColumn(
//                            modifier = Modifier
//                                .padding(horizontal = 16.dp)
//                                .padding(top = 24.dp)
//                                .fillMaxSize()
//                        ) {
//                            itemsIndexed(chatsList) { index, item ->
//                                item?.let {
//                                    ChatDirectConversationComponent(
//                                        chatBasicInfoEntity = it,
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .height(72.dp),
//                                        navigateToChat = {
//                                            viewModel.navigateToDirectChat(it.chatId)
//                                        }
//                                    )
//                                }
//
//                                if (index != chatsList.itemCount)
//                                    Spacer(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .height(1.dp)
//                                            .background(color = AppResources.colors.White70)
//                                    )
//                            }
//                        }
//                    }
//
//                }
//                TabModel.ServerTab ->{
//                    Column(
//                        modifier = Modifier
//                            .background(color = AppResources.colors.PurpleSemiDark)
//                            .padding(top = padding.calculateTopPadding())
//                            .fillMaxSize()
//                    ) {
//                        LazyColumn(
//                            modifier = Modifier
//                                .padding(horizontal = 16.dp)
//                                .padding(top = 24.dp)
//                                .fillMaxSize()
//                        ) {
//                            itemsIndexed(serversList) { index, item ->
//                                item?.let {
//                                    ServerItem(
//                                        serverEntity = it,
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .height(72.dp),
//                                        navigateToServer = {
//                                            viewModel.navigateToServerChat(it.serverId)
//                                        }
//                                    )
//                                }
//
//                                if (index != chatsList.itemCount)
//                                    Spacer(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .height(1.dp)
//                                            .background(color = AppResources.colors.White70)
//                                    )
//                            }
//                        }
//                    }
//                }
//
//                else -> {}
//            }
//
//        }
//    }
}
