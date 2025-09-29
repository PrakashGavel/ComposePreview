package com.example.composepreview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepreview.ui.theme.ComposePreviewTheme

@Composable
fun CustomButton(
    title: String,
    inOutline: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    if(inOutline){
        OutlinedButton(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier,
            border = BorderStroke(
                width = 1.dp,
                color = Color.Gray
            )
        ) {
            Text(text = title)
        }
    } else {
        Button(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier
        ) {
            Text(text = title)
        }
    }
}

@Preview(
   // showBackground = true,
//    widthDp = 300,
//    heightDp = 100,
    showSystemUi = true,
 //   uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = Devices.PIXEL,

    fontScale = 2f
)
@Composable
fun CustomButtonPreview() {
    androidx.compose.material3.MaterialTheme {
        CustomButton(
            title = "Hello World",
            inOutline = false,
            onClick = {}
        )
    }
}

//@Preview
//@Composable
//fun CustomButtonOutlinedPreview() {
//    androidx.compose.material3.MaterialTheme {
//        CustomButton(
//            title = "Hello World",
//            inOutline = true,
//            onClick = {}
//        )
//    }
//}



