package com.maxim.settings.language

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LanguageViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<LanguageUiState>(LanguageUiState.initial)
    val uiState = _uiState.asStateFlow()
}