package com.ersinberkealemdaroglu.deeplinkmanager.ui.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PrimaryBackground = Color(0xFF101922)
val PrimaryTextColor = Color(0xFFFFFFFF)
val SecondaryTextColor = Color(0xFF9FA3A6)
val PlaceholderTextColor = Color(0xFF65758C)
val PrimaryButtonColor = Color(0xFF137FEC)
val SecondaryButtonColor = Color(0xFF334155)
val DeleteButtonBgColor = Color(0xFF3C2229)
val HorizontalDividerColor = Color(0xFF2A323A)
val BackIconColor = Color(0xFF939AA6)
val TextFieldBackgroundColor = Color(0xFF1E293B)

internal object PrimaryButtonStyle {
    @Composable
    fun colors(): ButtonColors = ButtonColors(
        containerColor = PrimaryButtonColor,
        disabledContainerColor = SecondaryButtonColor,
        contentColor = PrimaryTextColor,
        disabledContentColor = SecondaryTextColor,
    )
}

internal object DeleteButtonStyle {
    @Composable
    fun colors(): ButtonColors = ButtonColors(
        containerColor = DeleteButtonBgColor,
        disabledContainerColor = SecondaryButtonColor,
        contentColor = PrimaryTextColor,
        disabledContentColor = SecondaryTextColor,
    )
}