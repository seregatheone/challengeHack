package pat.project.challengehack.screens.profile.profileScreen

import android.net.Uri
import android.os.Build
import android.webkit.MimeTypeMap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import core.ui.components.buttons.iconButton.CustomIconButton
import core.ui.components.buttons.iconButton.IconButtonStyles
import core.ui.components.sceletons.SkeletonWithContent
import core.ui.themes.AppResources
import pat.project.challengehack.R
import pat.project.challengehack.screens.profile.profileScreen.components.CategorySettingsComponent
import pat.project.challengehack.screens.profile.profileScreen.models.CategorySettings
import pat.project.conversay.screens.profile.profileScreen.models.ProfileNavDestinations

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileScreenViewModel = hiltViewModel(),
    navigateToWelcomePageWithPopBackStack: () -> Unit,
    navigateToAccountSettings: ()  -> Unit
) {
    val profileInfo by viewModel.profileInfo.collectAsState()

    val profileNavDestinations by viewModel.profileNavDestinations.collectAsState()

    LaunchedEffect(key1 = profileNavDestinations) {
        when (profileNavDestinations) {
            ProfileNavDestinations.DEFAULT -> {}
            ProfileNavDestinations.WELCOME_PAGE -> navigateToWelcomePageWithPopBackStack()
        }
    }

    //clipboardmanager

    val settingsList by remember {
        mutableStateOf(
            listOf(
                CategorySettings.AccountSettings,
                CategorySettings.AppSettings
            )
        )
    }

    Box(
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = AppResources.colors.Black)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .background(
                            color = AppResources.colors.Grey90_60,
                            shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
                        )
                )
                Column(
                    modifier = Modifier.align(Alignment.TopCenter)
                        .padding(top = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SkeletonWithContent(
                        showSkeleton = profileInfo == null,
                        modifier = Modifier
                            .padding(top = 22.dp)
                            .size(width = 80.dp, height = 20.dp),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier,
                            tint = AppResources.colors.White,
                        )
                    }

                    SkeletonWithContent(
                        showSkeleton = profileInfo == null,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .size(width = 60.dp, height = 32.dp),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(top = 4.dp),
                            style = AppResources.typography.headlines.headline2,
                            color = AppResources.colors.White,
                            text = profileInfo!!.username
                        )
                    }

                    SkeletonWithContent(
                        showSkeleton = profileInfo == null,
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .size(134.dp)
                            .border(
                                width = 5.dp,
                                color = AppResources.colors.Grey80,
                                shape = CircleShape
                            ),
                        shape = CircleShape
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .size(134.dp)
                                .clip(shape = CircleShape)
                                .border(
                                    width = 5.dp,
                                    color = AppResources.colors.White,
                                    shape = CircleShape
                                ),
                            contentScale = ContentScale.Crop,
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(profileInfo!!.profilePictureUrl)
                                .decoderFactory(SvgDecoder.Factory())
                                .build(),
                            contentDescription = null
                        )
                    }
                }

                CustomIconButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 22.dp, end = 10.dp),
                    iconButtonStyle = IconButtonStyles.MORE,
                    onCLick = {}
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
            ) {
                settingsList.forEach {
                    CategorySettingsComponent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 36.dp),
                        categorySettings = it,
                        navigateToAccountSettings = navigateToAccountSettings,
                    )
                }
            }

            Text(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource(),
                        onClick = viewModel::logout
                    )
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(
                        color = AppResources.colors.Grey90_60,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .padding(vertical = 8.dp),
                style = AppResources.typography.titles.title0,
                textAlign = TextAlign.Center,
                color = AppResources.colors.White,
                text = stringResource(id = R.string.logout)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
            )
        }
    }
}
