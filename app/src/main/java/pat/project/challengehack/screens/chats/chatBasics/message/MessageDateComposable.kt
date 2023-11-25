//package pat.project.conversay.screens.chatBasics.message
//
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import core.ui.themes.AppResources
//import pat.project.conversay.R
//import java.time.LocalDateTime
//
//
//@Composable
//fun MessageDateComposable(
//    modifier: Modifier = Modifier,
//    messageDate: LocalDateTime,
//    isRead: Boolean?
//) {
//    Row(
//        modifier = modifier,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = "${messageDate.hour}:${messageDate.minute.toString().padStart(2, '0')}",
//            style = AppResources.typography.body.b22.copy(
//                color = AppResources.colors
//            )
//        )
//        when (isRead) {
//            null -> {}
//            true -> Icon(
//                modifier = Modifier
//                    .padding(start = 6.dp)
//                    .size(14.dp),
//                painter = painterResource(id = ),
//                tint = AppResources.colors.
//                contentDescription = null
//            )
//            false ->
//                Icon(
//                    modifier = Modifier
//                        .padding(start = 6.dp)
//                        .size(14.dp),
//                    painter = painterResource(id = ),
//                    tint = AppResources.colors.
//                    contentDescription = null
//                )
//        }
//
//    }
//}