package com.maxim.home.screen.home_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState.initial())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            HomeScreenUiState.mock()
        }
    }
}