package com.ersinberkealemdaroglu.deeplinkmanager.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val ColorScheme = darkColorScheme(
    primary = PrimaryBackground,
    primaryContainer = PrimaryBackground,
    secondary = SecondaryTextColor,
    tertiary = PrimaryButtonColor
)

@Composable
fun DeeplinkManagerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ColorScheme, typography = typography, content = content
    )
}