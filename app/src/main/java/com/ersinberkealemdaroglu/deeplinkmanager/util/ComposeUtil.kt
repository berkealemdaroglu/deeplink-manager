package com.ersinberkealemdaroglu.deeplinkmanager.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

/**
 * Dalgalanma (ripple) efekti olmadan tıklama işlevi ekler.
 *
 * @param onClick Tıklama gerçekleştiğinde çağrılacak lambda fonksiyonu.
 */
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }, onClick = onClick
    )
}