package com.example.composepreview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
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
                width = if(LocalInspectionMode.current){  // This LocalInspectionMode is used is we want to skip some code while in preview mode. For example, if we are loading some image from network or doing some animation which we don't want to be executed in preview mode, we can use this LocalInspectionMode to check if we are in preview mode or not.
                    3.dp
                } else 1.dp,
                color = MaterialTheme.colorScheme.primary
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

//@Preview(
//   // showBackground = true,
////    widthDp = 300,
////    heightDp = 100,
//    showSystemUi = true,
// //   uiMode = Configuration.UI_MODE_NIGHT_YES,
//    device = Devices.PIXEL,
//
//    fontScale = 2f
//)

// Parameter Provider: To provide different parameters to the composable function in preview, we can use ParameterProvider. This is useful when we want to see how our composable looks with different data (complex data) without writing multiple preview functions.
// Here let's say we want to isOutline true and false both to be previewed, so we can use ParameterProvider for that.
class OnlineParameterProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean>
        get() = sequenceOf(false, true)  // passing all the possible values of isOutline.
}
@Preview
//@PreviewScreenSizes  // To preview on different screen sizes at once, we don't need to specify device or write multiple previews for different devices.
//@PreviewFontScale  // To preview on different font scales at once, we don't need to specify fontScale or write multiple previews for different font scales.
//@PreviewLightDark // To preview in both light and dark mode at once, we don't need to specify uiMode or write multiple previews for different modes.
@PreviewDynamicColors // To preview in both dynamic color enabled and disabled mode at once, we don't need to specify dynamicColor or write multiple previews for different modes.
@Composable
fun CustomButtonPreview(
    @PreviewParameter(OnlineParameterProvider::class) isOutline: Boolean  // it will show two previews, one with isOutline = true and another with isOutline = false.
) {
    ComposePreviewTheme {
        CustomButton(
            title = "Hello World",
            inOutline = isOutline,
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



