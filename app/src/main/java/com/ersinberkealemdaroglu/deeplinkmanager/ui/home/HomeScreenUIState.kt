package com.ersinberkealemdaroglu.deeplinkmanager.ui.home

import com.ersinberkealemdaroglu.deeplinkmanager.model.DeeplinkModel

data class HomeScreenUIState(
    val deeplinkList: List<DeeplinkModel> = emptyList(),
    val searchText: String = "",
    val uiModelState: HomeScreenUIModelState = HomeScreenUIModelState.NO_DATA,
)

enum class HomeScreenUIModelState {
    HAS_DATA, NO_DATA,
}