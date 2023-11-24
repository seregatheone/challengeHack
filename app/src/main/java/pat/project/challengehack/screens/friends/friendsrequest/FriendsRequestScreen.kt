package pat.project.challengehack.screens.friends.friendsrequest

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FriendsRequestScreen(
    modifier: Modifier = Modifier,
    viewModel: FriendsRequestViewModel = hiltViewModel(),
    onClickBack: () -> Unit
) {
//    val friendList = viewModel.friendOffersList.collectAsLazyPagingItems()
//
//
//    Scaffold(modifier = modifier
//        .statusBarsPadding(),
//        topBar = {
//            Box(
//                modifier = Modifier
//                    .background(color = AppResources.colors.SystemHeader)
//                    .fillMaxWidth()
//                    .height(62.dp)
//                    .padding(start = 18.dp)
//
//            ) {
//                CustomIconButton(
//                    iconButtonStyle = IconButtonStyles.ARROW_BACK,
//                    onCLick = { onClickBack() },
//                    modifier = Modifier.align(Alignment.CenterStart),
//                    color = AppResources.colors.PurpleGreyMedium
//                )
//
//                Text(
//                    text = stringResource(id = R.string.title_friends_request),
//                    style = AppResources.typography.titles.title0,
//                    modifier = Modifier.align(Alignment.Center)
//                )
//
//            }
//        }
//    ) { it ->
//        Column(
//            modifier = modifier
//                .background(color = AppResources.colors.PurpleSemiDark)
//                .padding(it)
//        ) {
//            LazyColumn(
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .padding(top = 24.dp)
//                    .fillMaxSize()
//            ) {
//                itemsIndexed(friendList) { index, item ->
//                    item?.let {
//                        FriendRequestItem(
//                            friendEntity = it,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(100.dp),
//                            onAcceptRequest = viewModel::acceptFriendRequest,
//                            onDeclineRequest = viewModel::rejectFriendRequest,
//                        )
//                    }
//
//                    if (index != friendList.itemCount)
//                        Spacer(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(1.dp)
//                                .background(color = AppResources.colors.White70)
//                        )
//                }
//            }
//        }
//    }

}