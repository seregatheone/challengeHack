package core.ui.components.snackbar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SnackBarComponent(
    modifier: Modifier = Modifier,
    snackBarStyle: SnackBarStyle,
    message: String = "",
) {
    val localsSnackBarStyle = getLocalSnackBarStyles(snackBarStyle)

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = localsSnackBarStyle.backgroundColor
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            text = message,
            textAlign = TextAlign.Start,
            color = localsSnackBarStyle.textColor,
            style = localsSnackBarStyle.textStyle
        )

    }

}

@Composable
fun getLocalSnackBarStyles(snackBarStyle: SnackBarStyle): SnackBarStyle {
    return when(snackBarStyle){
        SnackBarStyle.RedStyle -> SnackBarStyle.RedStyle.initResourcesImpl()
        SnackBarStyle.GreenStyle -> SnackBarStyle.GreenStyle.initResourcesImpl()
    }
}