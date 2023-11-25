package core.ui.components.inputComponents.inputComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import core.ui.themes.AppResources

@Composable
fun InputComponent(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit = {},
    placeholder: String = "",
    isValid: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    backgroundColor: Color = AppResources.colors.Grey90_60,
    textColor: Color = AppResources.colors.Grey80
){
    var isFocused by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = AppResources.typography.titles.title1.copy(color = AppResources.colors.White),
            keyboardOptions = keyboardOptions,
            modifier = Modifier
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .background(
                    (backgroundColor),
                    shape = RoundedCornerShape(12.dp)
                )
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .padding(vertical = 10.dp),
            decorationBox = { innerTextBox ->
                if (!isFocused && value.isEmpty()) {
                    Text(
                        modifier = Modifier
                            .background(Color.Unspecified),
                        text = placeholder,
                        style = AppResources.typography.titles.title1.copy(color = textColor),
                    )
                } else {
                    innerTextBox()
                }
            },
            visualTransformation = visualTransformation,
            cursorBrush = SolidColor(AppResources.colors.White)
        )
//        if (!isValid){
//            Spacer(modifier = Modifier.padding(vertical = 10.dp))
//            Text(text = stringResource(id = R.string.email_error),
//                style = AppResources.typography.titles.title2,
//                color = AppResources.colors.SystemError,
//                modifier = Modifier
//                    .padding(start = 20.dp))
//        }
    }

}