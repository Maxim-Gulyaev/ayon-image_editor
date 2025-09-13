package com.maxim.settings.language

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.userPrefsDataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LanguageViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(LanguageUiState.initial)
    val uiState: StateFlow<LanguageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val dataSource =
                UserPreferencesDataSource(
                    dataStore = application.userPrefsDataStore
                )
            dataSource.appLanguage.collectLatest { language ->
                _uiState.update {
                    it.copy(currentAppLanguage = language)
                }
            }
        }
    }

    fun accept(intent: LanguageIntent) {
        when (intent) {

            is LanguageIntent.OnLanguageClick -> _uiState.update {
                it.copy(currentAppLanguage = intent.appLanguage)
            }
        }
    }
}