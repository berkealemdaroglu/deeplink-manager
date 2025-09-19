package com.ersinberkealemdaroglu.deeplinkmanager.ui.home

import com.ersinberkealemdaroglu.deeplinkmanager.model.DeeplinkModel

data class HomeScreenUIState(
    val deeplinkList: List<DeeplinkModel> = emptyList(),
)