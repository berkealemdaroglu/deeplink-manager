package com.ersinberkealemdaroglu.deeplinkmanager.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PlaceholderTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.TextFieldBackgroundColor

@Composable
fun TextFiledGetirir(
    modifier: Modifier,
    text: String,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier, shape = RoundedCornerShape(16.dp), placeholder = {
            Text(
                text = placeholder, style = MaterialTheme.typography.bodyMedium, color = PlaceholderTextColor
            )
        }, trailingIcon = trailingIcon, keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
        ), colors = TextFieldDefaults.colors().copy(
            focusedTextColor = PrimaryTextColor,
            unfocusedTextColor = PrimaryTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = TextFieldBackgroundColor,
            unfocusedContainerColor = TextFieldBackgroundColor,
            disabledContainerColor = TextFieldBackgroundColor,
            cursorColor = PrimaryTextColor
        ), value = text, onValueChange = { text ->
            onValueChange.invoke(text)
        })
}