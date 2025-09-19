package com.ersinberkealemdaroglu.deeplinkmanager.navigation

import kotlinx.serialization.Serializable

sealed class Screens {
    @Serializable
    object Home : Screens()

    @Serializable
    object AddDeeplink : Screens()

    @Serializable
    data class DeeplinkDetail(val id: Int, val title: String, val url: String) : Screens()
}