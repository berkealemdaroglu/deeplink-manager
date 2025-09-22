package com.ersinberkealemdaroglu.deeplinkmanager.ui.home

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ersinberkealemdaroglu.deeplinkmanager.model.DeeplinkModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DeeplinkSharedViewModel(
    private val application: Application,
) : AndroidViewModel(application) {

    private val _homeUiState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(HomeScreenUIState())
    val homeUiState: MutableStateFlow<HomeScreenUIState> = _homeUiState

    private val sharedPreferences: SharedPreferences = getApplication<Application>().getSharedPreferences(
        "deeplink_prefs", Context.MODE_PRIVATE
    )

    private var originalDeeplinkList: List<DeeplinkModel>? = null

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        val data = sharedPreferences.getString("deeplink", null)?.toDataModel()
        originalDeeplinkList = data ?: emptyList()
        _homeUiState.update { state ->
            state.copy(
                deeplinkList = data ?: emptyList(),
                uiModelState = if (data.isNullOrEmpty()) HomeScreenUIModelState.NO_DATA else HomeScreenUIModelState.HAS_DATA
            )
        }
    }

    fun saveDeeplinkData(deeplinkModel: DeeplinkModel) = viewModelScope.launch {
        val currentList = _homeUiState.value.deeplinkList.toMutableList()
        currentList.add(deeplinkModel)
        updateAllDeeplinkData(currentList)
    }

    fun updateDeeplinkData(deeplinkModel: DeeplinkModel) = viewModelScope.launch {
        val currentList = _homeUiState.value.deeplinkList
        val updatedList = currentList.map { if (it.id == deeplinkModel.id) deeplinkModel else it }
        updateAllDeeplinkData(updatedList)
    }

    fun removeDeeplinkData(deeplinkModel: DeeplinkModel) = viewModelScope.launch {
        val currentList = _homeUiState.value.deeplinkList.toMutableList()
        currentList.remove(deeplinkModel)
        updateAllDeeplinkData(currentList)
    }

    fun updateAllDeeplinkData(deeplinkList: List<DeeplinkModel>) = viewModelScope.launch {
        _homeUiState.update { state ->
            state.copy(
                deeplinkList = deeplinkList,
                uiModelState = if (deeplinkList.isEmpty()) HomeScreenUIModelState.NO_DATA else HomeScreenUIModelState.HAS_DATA
            )
        }

        saveSharedPreferences(deeplinkList.toMutableList())
    }

    fun onSearchTextChange(newText: String) = viewModelScope.launch {
        val filteredList = if (newText.isEmpty()) {
            originalDeeplinkList
        } else {
            originalDeeplinkList?.filter {
                it.title.contains(newText.trimEnd(), ignoreCase = true) || it.url.contains(newText.trimEnd(), ignoreCase = true)
            }
        }

        _homeUiState.update { state ->
            state.copy(searchText = newText, deeplinkList = filteredList ?: emptyList())
        }
    }

    private fun saveSharedPreferences(data: List<DeeplinkModel>) = viewModelScope.launch {
        originalDeeplinkList = data
        sharedPreferences.edit { putString("deeplink", data.toMutableList().toStringModel()) }
    }

    private fun <T> MutableList<T>.toStringModel(): String {
        return Gson().toJson(this)
    }

    private fun String.toDataModel(): List<DeeplinkModel> {
        return Gson().fromJson(this, Array<DeeplinkModel>::class.java).toList()
    }

}