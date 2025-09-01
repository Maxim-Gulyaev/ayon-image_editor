package com.maxim.home.view_model

import androidx.lifecycle.ViewModel
import com.maxim.home.model.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState.initial)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
}