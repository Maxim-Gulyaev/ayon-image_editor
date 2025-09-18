package com.maxim.settings.language_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCase
import com.maxim.settings.model.toDomain
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
    private val setAppLanguageUseCase: SetAppLanguageUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LanguageUiState.initial)
    val uiState: StateFlow<LanguageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            setCurrentLanguage()
        }
    }

    fun accept(intent: LanguageIntent) {
        when (intent) {
            LanguageIntent.OnSaveButtonClick -> {
                val newAppLanguage = _uiState.value.selectedLanguage.toDomain()
                viewModelScope.launch {
                    setAppLanguageUseCase(newAppLanguage)
                }
            }

            is LanguageIntent.OnLanguageClick -> {
                _uiState.update {
                    it.copy(selectedLanguage = intent.language)
                }
            }
        }
    }

    private suspend fun setCurrentLanguage() {
        getAppLanguageUseCase().collectLatest { language ->
            val currentAppLanguage = language.toUi()
            _uiState.update {
                it.copy(
                    currentAppLanguage = currentAppLanguage,
                    selectedLanguage = currentAppLanguage,
                )
            }
        }
    }
}