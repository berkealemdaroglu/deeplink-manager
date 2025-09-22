package com.ersinberkealemdaroglu.deeplinkmanager.ui.component

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeeplinkManagerTheme
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeleteButtonStyle
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryButtonStyle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    val coroutineScope = rememberCoroutineScope()
    val debouncedClick = remember {
        coroutineScope.debounceClick(onClick = onClick)
    }
    Button(
        modifier = modifier.defaultMinSize(minHeight = 48.dp, minWidth = 1.dp),
        shape = RoundedCornerShape(8.dp),
        colors = PrimaryButtonStyle.colors(),
        onClick = {
            debouncedClick.invoke()
        },
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
    val coroutineScope = rememberCoroutineScope()
    val debouncedClick = remember {
        coroutineScope.debounceClick(onClick = onClick)
    }

    Button(
        modifier = modifier.defaultMinSize(minHeight = 48.dp, minWidth = 1.dp),
        shape = RoundedCornerShape(8.dp),
        colors = DeleteButtonStyle.colors(),
        onClick = {
            debouncedClick.invoke()
        },
        enabled = enabled,
    ) {
        Text(
            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle, fontSize = 16.sp, text = text
        )
    }
}

@OptIn(FlowPreview::class)
fun CoroutineScope.debounceClick(
    debounceTime: Long = 500L,
    onClick: () -> Unit,
): () -> Unit {
    val events = MutableSharedFlow<Unit>(replay = 0, extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    launch {
        events.debounce(debounceTime).collectLatest {
                onClick.invoke()
            }
    }

    return {
        events.tryEmit(Unit)
    }
}

@Preview
@Composable
private fun PreviewPrimaryButton() {
    DeeplinkManagerTheme {
        PrimaryButton(onClick = {}, text = "Primary Button")
    }
}