package com.ersinberkealemdaroglu.deeplinkmanager.ui.adddeeplink

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ersinberkealemdaroglu.deeplinkmanager.ui.component.CustomToolbar
import com.ersinberkealemdaroglu.deeplinkmanager.ui.component.PrimaryButton
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeeplinkManagerTheme
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.HorizontalDividerColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PlaceholderTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryBackground
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.SecondaryTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.TextFieldBackgroundColor

@Composable
fun AddDeeplinkScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
    onSaveDeeplinkButtonClicked: ((title: String, url: String) -> Unit)? = null,
) {
    val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }


    Column(modifier = modifier) {
        CustomToolbar(
            modifier = Modifier.fillMaxWidth(),
            title = "Add Deeplink",
            shouldShowNavIcon = true,
            navigationIcon = { onBackButtonClicked.invoke() })

        HorizontalDivider(
            thickness = 1.5.dp, color = HorizontalDividerColor
        )

        Spacer(Modifier.height(16.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Title",
            style = MaterialTheme.typography.titleMedium,
            color = SecondaryTextColor,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(4.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), shape = RoundedCornerShape(16.dp), placeholder = {
                Text(
                    text = "Enter a title for the deeplink",
                    style = MaterialTheme.typography.bodyMedium,
                    color = PlaceholderTextColor
                )
            }, keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ), colors = TextFieldDefaults.colors().copy(
                focusedTextColor = PrimaryTextColor,
                unfocusedTextColor = PrimaryTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = TextFieldBackgroundColor,
                unfocusedContainerColor = TextFieldBackgroundColor,
                disabledContainerColor = TextFieldBackgroundColor,
                cursorColor = PrimaryTextColor
            ), value = title, onValueChange = { text ->
                title = text
            })

        Spacer(Modifier.height(16.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Url",
            style = MaterialTheme.typography.titleMedium,
            color = SecondaryTextColor,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(4.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors().copy(
                focusedTextColor = PrimaryTextColor,
                unfocusedTextColor = PrimaryTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = TextFieldBackgroundColor,
                unfocusedContainerColor = TextFieldBackgroundColor,
                disabledContainerColor = TextFieldBackgroundColor,
                cursorColor = PrimaryTextColor
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            placeholder = {
                Text(
                    text = "Enter the deeplink URL", style = MaterialTheme.typography.bodyMedium, color = PlaceholderTextColor
                )
            },
            value = url,
            onValueChange = { text ->
                url = text
            })

        Spacer(Modifier.weight(1f))

        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp), text = "Add New Deeplink", onClick = {
                if (url.isNotEmpty() && title.isNotEmpty()) {
                    onSaveDeeplinkButtonClicked?.invoke(
                        title, url
                    )
                } else {
                    Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
            })

        Spacer(Modifier.height(32.dp))

    }
}


@Preview(device = Devices.PIXEL_2_XL, showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    DeeplinkManagerTheme {
        AddDeeplinkScreen(
            Modifier
                .background(PrimaryBackground)
                .fillMaxSize(),
            onBackButtonClicked = {},
            onSaveDeeplinkButtonClicked = { title, url ->

            })
    }
}