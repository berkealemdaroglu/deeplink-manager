package com.ersinberkealemdaroglu.deeplinkmanager.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ersinberkealemdaroglu.deeplinkmanager.R
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.BackIconColor
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.DeeplinkManagerTheme
import com.ersinberkealemdaroglu.deeplinkmanager.ui.theme.PrimaryTextColor
import com.ersinberkealemdaroglu.deeplinkmanager.util.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolbar(modifier: Modifier, title: String, shouldShowNavIcon: Boolean = false, navigationIcon: (() -> Unit)? = null) {
    Row(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        if (shouldShowNavIcon) {
            Box(
                modifier = Modifier
                    .width(56.dp)
                    .noRippleClickable { navigationIcon?.invoke() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.width(24.dp),
                    tint = BackIconColor,
                    painter = painterResource(R.drawable.ic_back_icon),
                    contentDescription = null,
                )
            }
        }

        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Text(
                text = title, style = MaterialTheme.typography.titleLarge, color = PrimaryTextColor, textAlign = TextAlign.Center
            )
        }

        if (shouldShowNavIcon) {
            Spacer(modifier = Modifier.width(56.dp))
        }
    }
}

@Preview(device = Devices.PIXEL_2_XL, showBackground = true, showSystemUi = true, backgroundColor = 0xFF101922)
@Composable
private fun PreviewToolbar() {
    DeeplinkManagerTheme {
        CustomToolbar(modifier = Modifier.fillMaxWidth(), title = "Deeplink Manager", navigationIcon = {
            // Do nothing
        })
    }
}