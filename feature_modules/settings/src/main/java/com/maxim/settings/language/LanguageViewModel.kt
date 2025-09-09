package com.maxim.settings.language

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LanguageViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(LanguageUiState.initial)
    val uiState: StateFlow<LanguageUiState> = _uiState.asStateFlow()

    init {
        Log.d("maxlog", "VM init: ${this.hashCode()}")
    }

    fun accept(intent: LanguageIntent) {
        when (intent) {

            is LanguageIntent.OnLanguageClick -> _uiState.update {
                it.copy(currentLanguage = intent.language)
            }
        }
    }
}