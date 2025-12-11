package com.maxim.settings.screen.language_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.common.result.Result
import com.maxim.common.result.asResult
import com.maxim.common.util.Logger
import com.maxim.domain.use_case.get_app_language.GetAppLanguageUseCase
import com.maxim.domain.use_case.set_app_language.SetAppLanguageUseCase
import com.maxim.settings.model.AppLanguageUi
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
    private val logger: Logger,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LanguageUiState())
    val uiState: StateFlow<LanguageUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            setCurrentLanguage()
        }
    }

    fun accept(intent: LanguageScreenIntent) {
        when (intent) {
            LanguageScreenIntent.OnSaveButtonClick -> {
                val newAppLanguage = _uiState.value.selectedLanguage.toDomain()
                viewModelScope.launch {
                    setAppLanguageUseCase(newAppLanguage)
                }
            }

            is LanguageScreenIntent.OnLanguageClick -> {
                _uiState.update {
                    it.copy(selectedLanguage = intent.language)
                }
            }
        }
    }

    private suspend fun setCurrentLanguage() {
        val language = getAppLanguageUseCase()
        language
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Success -> {
                        val languageUi = result.data.toUi()
                        _uiState.update {
                            it.copy(
                                currentAppLanguage = languageUi,
                                selectedLanguage = languageUi,
                                screenState = LanguageScreenState.Loaded,
                            )
                        }
                    }

                    is Result.Error -> {
                        _uiState.update {
                            it.copy(
                                currentAppLanguage = AppLanguageUi.SYSTEM,
                                selectedLanguage = AppLanguageUi.SYSTEM,
                                screenState = LanguageScreenState.Loaded,
                            )
                        }
                        logger.e("ayon_error", "setCurrentLanguage() ${result.exception}")
                    }

                    Result.Loading -> {}
                }
            }
    }
}