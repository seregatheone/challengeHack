package pat.project.challengehack.screens.chats.chatBasics.datespacer

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.ui.themes.AppResources
import java.time.LocalDateTime

@Composable
fun DateSpacer(
    modifier: Modifier = Modifier,
    date: LocalDateTime
) {
    val now = LocalDateTime.now()

    val dateString = StringBuilder()
    if (now.year == date.year) {
        dateString.append(
            date.month.name

        )
    } else {
        dateString.append(
            "${date.year} ${date.month.name}"
        )
    }
    dateString.append(", ${date.dayOfMonth}")
    Text(
        modifier = modifier,
        text = dateString.toString(),
        style = AppResources.typography.body.body1.copy(
            color = AppResources.colors.White
        )
    )
}