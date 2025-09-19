package com.ersinberkealemdaroglu.deeplinkmanager.ui.component

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeeplinkManagerTheme
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeleteButtonStyle
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryButtonStyle

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier.defaultMinSize(minHeight = 48.dp, minWidth = 1.dp),
        shape = RoundedCornerShape(8.dp),
        colors = PrimaryButtonStyle.colors(),
        onClick = onClick,
        enabled = enabled,
    ) {
        Text(
            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle, fontSize = 16.sp, text = text
        )
    }
}


@Composable
fun DeleteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier.defaultMinSize(minHeight = 48.dp, minWidth = 1.dp),
        shape = RoundedCornerShape(8.dp),
        colors = DeleteButtonStyle.colors(),
        onClick = onClick,
        enabled = enabled,
    ) {
        Text(
            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle, fontSize = 16.sp, text = text
        )
    }
}

@Preview
@Composable
private fun PreviewPrimaryButton() {
    DeeplinkManagerTheme {
        PrimaryButton(onClick = {}, text = "Primary Button")
    }
}