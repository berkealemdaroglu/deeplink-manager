package com.ersinberkealemdaroglu.deeplinkmanager.navigation

import com.ersinberkealemdaroglu.deeplinkmanager.ui.adddeeplink.AddDeeplinkScreenRegisterer
import com.ersinberkealemdaroglu.deeplinkmanager.ui.deeplinkdetail.DeeplinkDetailScreenRegisterer
import com.ersinberkealemdaroglu.deeplinkmanager.ui.home.HomeScreenRegisterer

object NavProviderFactory {
    fun createNavProvider(): NavProvider {
        val screens = listOf(
            NavProviderItem(HomeScreenRegisterer()),
            NavProviderItem(AddDeeplinkScreenRegisterer()),
            NavProviderItem(DeeplinkDetailScreenRegisterer()),
        )
        return NavProvider(screens)
    }
}