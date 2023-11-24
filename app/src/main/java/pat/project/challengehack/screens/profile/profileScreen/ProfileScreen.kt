package pat.project.challengehack.screens.profile.profileScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileScreenViewModel = hiltViewModel(),
    navigateToWelcomePageWithPopBackStack: () -> Unit,
    navigateToAccountSettings: ()  -> Unit
) {
//    val profileInfo by viewModel.profileInfo.collectAsState()
//
//    val profileNavDestinations by viewModel.profileNavDestinations.collectAsState()
//
//    LaunchedEffect(key1 = profileNavDestinations) {
//        when (profileNavDestinations) {
//            ProfileNavDestinations.DEFAULT -> {}
//            ProfileNavDestinations.WELCOME_PAGE -> navigateToWelcomePageWithPopBackStack()
//        }
//    }
//
//    //clipboardmanager
//
//    var isDialogVisible by remember {
//        mutableStateOf(false)
//    }
//
//    val coroutineScope = rememberCoroutineScope()
//
//    val settingsList by remember {
//        mutableStateOf(
//            listOf(
//                CategorySettings.AccountSettings,
//                CategorySettings.AppSettings
//            )
//        )
//    }
//
//    val context = LocalContext.current
//
//    var imageUri by remember {
//        mutableStateOf<Uri?>(null)
//    }
//
//    val launcherGallery = rememberLauncherForActivityResult(
//        contract =
//        ActivityResultContracts.GetContent()
//    ) { uri: Uri? ->
//        imageUri = uri
//        imageUri?.let { uri ->
//            context.contentResolver.openInputStream(uri)?.use {
//                viewModel.setAvatar(
//                    uri,
//                    it,
//                    MimeTypeMap.getSingleton()
//                        .getExtensionFromMimeType(context.contentResolver.getType(uri)) ?: ".jpg",
//                )
//            }
//        }
//    }
//
//    val launcherCamera = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.TakePicture(),
//    ) {
//        imageUri?.let { uri ->
//            context.contentResolver.openInputStream(uri)?.use {
//                viewModel.setAvatar(
//                    uri,
//                    it,
//                    MimeTypeMap.getSingleton()
//                        .getExtensionFromMimeType(context.contentResolver.getType(uri)) ?: ".jpg",
//                )
//            }
//        }
//    }
//
//    val launchGalleryPermission = rememberLauncherForActivityResult(
//        ActivityResultContracts.RequestMultiplePermissions()
//    ) { permission ->
//        var isGranted = true
//        permission.entries.forEach {
//            if (!it.value) isGranted = false
//        }
//        if (isGranted) {
//            launcherGallery.launch("image/*")
//        }
//    }
//
//    val launchCameraPermission = rememberLauncherForActivityResult(
//        ActivityResultContracts.RequestMultiplePermissions()
//    ) { permission ->
//        var isGranted = true
//        permission.entries.forEach {
//            if (!it.value) isGranted = false
//        }
//        if (isGranted) {
//            try {
//                imageUri = FilesUtil.getImageUri(context)
//                launcherCamera.launch(imageUri)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//
//    Box(
//        modifier = modifier
//            .statusBarsPadding()
//            .fillMaxSize()
//    ) {
//
//        if (isDialogVisible) {
//            Dialog(
//                onDismissRequest = { isDialogVisible = false }
//            ) {
//                Column(
//                    modifier = Modifier
//                        .background(
//                            color = AppResources.colors.DarkPurple,
//                            shape = RoundedCornerShape(12.dp)
//                        )
//                        .padding(24.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.choose_image_storage),
//                        style = AppResources.typography.titles.title1,
//                        color = AppResources.colors.White,
//                        textAlign = TextAlign.Center
//                    )
//
//                    Button(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 12.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = AppResources.colors.PurpleGreyLight
//                        ),
//                        onClick = {
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                                launchGalleryPermission.launch(
//                                    arrayOf(
//                                        Manifest.permission.READ_MEDIA_IMAGES,
//                                    )
//                                )
//                            } else {
//                                launchGalleryPermission.launch(
//                                    arrayOf(
//                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                                    )
//                                )
//                            }
//                            coroutineScope.launch {
//                                isDialogVisible = false
//                            }
//                        }) {
//                        Text(
//                            text = stringResource(id = R.string.pick_from_gallery),
//                            style = AppResources.typography.body.body0,
//                            color = AppResources.colors.White
//                        )
//                    }
//                    Button(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 12.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = AppResources.colors.PurpleGreyLight
//                        ),
//                        onClick = {
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                                launchCameraPermission.launch(
//                                    arrayOf(
//                                        Manifest.permission.CAMERA,
//                                        Manifest.permission.READ_MEDIA_IMAGES,
//                                    )
//                                )
//                            } else {
//                                launchCameraPermission.launch(
//                                    arrayOf(
//                                        Manifest.permission.CAMERA,
//                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                                    )
//                                )
//                            }
//                            coroutineScope.launch {
//                                isDialogVisible = false
//                            }
//                        }) {
//                        Text(
//                            text = stringResource(id = R.string.take_photo),
//                            style = AppResources.typography.body.body0,
//                            color = AppResources.colors.White
//                        )
//                    }
//                }
//            }
//        }
//
//
//        Column(
//            Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
//                .background(color = AppResources.colors.PurpleSemiDark)
//        ) {
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Spacer(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(190.dp)
//                        .background(
//                            color = AppResources.colors.DarkPurple,
//                            shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
//                        )
//                )
//                Column(
//                    modifier = Modifier.align(Alignment.TopCenter),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    SkeletonWithContent(
//                        showSkeleton = profileInfo == null,
//                        modifier = Modifier
//                            .padding(top = 22.dp)
//                            .size(width = 80.dp, height = 20.dp),
//                        shape = RoundedCornerShape(4.dp)
//                    ) {
//                        Text(
//                            modifier = Modifier.padding(top = 22.dp),
//                            style = AppResources.typography.body.body1,
//                            color = AppResources.colors.White70,
//                            text = stringResource(id = R.string.user_id, profileInfo!!.userId.toString())
//                        )
//                    }
//
//                    SkeletonWithContent(
//                        showSkeleton = profileInfo == null,
//                        modifier = Modifier
//                            .padding(top = 4.dp)
//                            .size(width = 60.dp, height = 32.dp),
//                        shape = RoundedCornerShape(4.dp)
//                    ) {
//                        Text(
//                            modifier = Modifier
//                                .padding(top = 4.dp),
//                            style = AppResources.typography.headlines.headline2,
//                            color = AppResources.colors.White,
//                            text = profileInfo!!.username
//                        )
//                    }
//
//                    SkeletonWithContent(
//                        showSkeleton = profileInfo == null,
//                        modifier = Modifier
//                            .padding(top = 20.dp)
//                            .size(134.dp)
//                            .border(
//                                width = 5.dp,
//                                color = AppResources.colors.DarkOnPurple,
//                                shape = CircleShape
//                            ),
//                        shape = CircleShape
//                    ) {
//                        AsyncImage(
//                            modifier = Modifier
//                                .padding(top = 20.dp)
//                                .clickable(
//                                    enabled = true,
//                                    indication = null,
//                                    interactionSource = MutableInteractionSource(),
//                                    onClick = {
//                                        isDialogVisible = true
//                                    }
//                                )
//                                .size(134.dp)
//                                .clip(shape = CircleShape)
//                                .border(
//                                    width = 5.dp,
//                                    color = AppResources.colors.DarkOnPurple,
//                                    shape = CircleShape
//                                ),
//                            contentScale = ContentScale.Crop,
//                            model = ImageRequest.Builder(LocalContext.current)
//                                .placeholder(R.drawable.profile_image_placeholder_surface)
//                                .error(R.drawable.profile_image_placeholder_surface)
//                                .data(profileInfo!!.profilePictureUrl)
//                                .decoderFactory(SvgDecoder.Factory())
//                                .build(),
//                            contentDescription = null
//                        )
//                    }
//                }
//
//                CustomIconButton(
//                    modifier = Modifier
//                        .align(Alignment.TopEnd)
//                        .padding(top = 22.dp, end = 10.dp),
//                    iconButtonStyle = IconButtonStyles.MORE,
//                    onCLick = {}
//                )
//            }
//
//            Column(
//                modifier = Modifier
//                    .padding(top = 24.dp)
//                    .padding(horizontal = 7.dp)
//                    .fillMaxWidth()
//            ) {
//                settingsList.forEach {
//                    CategorySettingsComponent(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(bottom = 36.dp),
//                        categorySettings = it,
//                        navigateToAccountSettings = navigateToAccountSettings,
//                    )
//                }
//            }
//
//            Text(
//                modifier = Modifier
//                    .clickable(
//                        indication = null,
//                        interactionSource = MutableInteractionSource(),
//                        onClick = viewModel::logout
//                    )
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp)
//                    .background(
//                        color = AppResources.colors.PurpleDark,
//                        shape = RoundedCornerShape(12.dp),
//                    )
//                    .padding(vertical = 8.dp),
//                style = AppResources.typography.titles.title0,
//                textAlign = TextAlign.Center,
//                color = AppResources.colors.SystemError,
//                text = stringResource(id = R.string.logout)
//            )
//
//            Spacer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(36.dp)
//            )
//        }
//    }
}
