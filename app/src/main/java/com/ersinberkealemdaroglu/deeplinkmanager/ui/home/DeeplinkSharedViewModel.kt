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

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        val data = sharedPreferences.getString("deeplink", null)?.toDataModel()
        _homeUiState.update { state ->
            state.copy(deeplinkList = data ?: emptyList())
        }
    }

    fun saveDeeplinkData(deeplinkModel: DeeplinkModel) = viewModelScope.launch {
        val currentList = _homeUiState.value.deeplinkList.toMutableList()
        currentList.add(deeplinkModel)
        _homeUiState.update { state ->
            state.copy(deeplinkList = currentList)
        }
        saveSharedPreferences(currentList.toStringModel())
    }

    fun updateDeeplinkData(deeplinkModel: DeeplinkModel) = viewModelScope.launch {
        val currentList = _homeUiState.value.deeplinkList
        val updatedList = currentList.map { if (it.id == deeplinkModel.id) deeplinkModel else it }
        _homeUiState.update { state ->
            state.copy(deeplinkList = updatedList)
        }

        saveSharedPreferences(updatedList.toMutableList().toStringModel())
    }

    fun removeDeeplinkData(deeplinkModel: DeeplinkModel) = viewModelScope.launch {
        val currentList = _homeUiState.value.deeplinkList.toMutableList()
        currentList.remove(deeplinkModel)
        _homeUiState.update { state ->
            state.copy(deeplinkList = currentList)
        }

        saveSharedPreferences(currentList.toStringModel())
    }

    private fun saveSharedPreferences(data: String) = viewModelScope.launch {
        sharedPreferences.edit { putString("deeplink", data) }
    }

    private fun <T> MutableList<T>.toStringModel(): String {
        return Gson().toJson(this)
    }

    private fun String.toDataModel(): List<DeeplinkModel> {
        return Gson().fromJson(this, Array<DeeplinkModel>::class.java).toList()
    }

}