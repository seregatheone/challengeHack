package pat.project.challengehack.screens.chats.chatBasics.message

import android.Manifest
import android.app.Activity
import android.os.Build
import android.os.Environment
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources
import java.time.LocalDateTime


@Composable
fun MessageContent(
    modifier: Modifier = Modifier,
    messageContent: String,
) {
    BasicText(
        modifier = modifier
            .widthIn(max = 300.dp)
            .padding(
                start = 10.dp,
                end = 10.dp,
                bottom = 4.dp,
                top = 8.dp
            ),
        text = messageContent,
        style = AppResources.typography.body.body0.copy(
            color = AppResources.colors.White
        )
    )
}