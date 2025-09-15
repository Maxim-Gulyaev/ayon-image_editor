package com.maxim.settings.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.settings.model.toUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LanguageViewModel @Inject constructor(
    private val getAppLanguageUseCase: GetAppLanguageUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LanguageUiState.initial)
    val uiState: StateFlow<LanguageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            updateLanguage()
        }
    }

    fun accept(intent: LanguageIntent) {
        /*when (intent) {
            is LanguageIntent.OnLanguageClick -> {
                viewModelScope.launch {
                    userPreferencesDataSource.updateAppLanguage(intent.appLanguage)
                }
            }
        }*/
    }

    private suspend fun updateLanguage() {
        getAppLanguageUseCase().collectLatest { language ->
            _uiState.update {
                it.copy(currentAppLanguage = language.toUi())
            }
        }
    }
}