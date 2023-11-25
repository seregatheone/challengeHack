package pat.project.challengehack.screens.rooms.roomsScreenStart.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import core.ui.themes.AppResources
import pat.project.challengehack.R


@Composable
fun buildAnnotationStringWithSong(song : String) : AnnotatedString {
    return buildAnnotatedString {
        pushStyle(
            AppResources.typography.body.body1.toSpanStyle()
                .copy(color = AppResources.colors.Grey70)
        )
        append(stringResource(id = R.string.now_playing_track))
        pop()

        append(" ")

        pushStyle(
            AppResources.typography.body.body1.toSpanStyle()
                .copy(color = AppResources.colors.White)
        )
        append(song)
        pop()

    }
}