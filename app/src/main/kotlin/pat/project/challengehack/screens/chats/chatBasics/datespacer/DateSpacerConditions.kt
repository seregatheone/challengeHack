package pat.project.challengehack.screens.chats.chatBasics.datespacer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pat.project.challengehack.screens.chats.chatBasics.datespacer.DateSpacer
import java.time.LocalDateTime

@Composable
fun DateSpacerConditions(
    prevDate: LocalDateTime?,
    currentDate: LocalDateTime
) {
    Box(modifier = Modifier.fillMaxWidth()){
        when (prevDate) {
            null -> {
                DateSpacer(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(vertical = 6.dp)
                    ,
                    date = currentDate
                )
            }
            else -> {
                //Проверка года сообщения
                //Можно сделать проверку на то что сообщение было отправлено сегодня или т.п.
                if (prevDate.year == currentDate.year && prevDate.dayOfYear != currentDate.dayOfYear) {
                    DateSpacer(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(vertical = 6.dp),
                        date = currentDate
                    )
                }

            }

        }
    }

}