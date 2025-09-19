package com.ersinberkealemdaroglu.deeplinkmanager.navigation

data class NavProvider(
    val screens: List<NavProviderItem>,
)

data class NavProviderItem(
    val screen: NavRegisterer,
)