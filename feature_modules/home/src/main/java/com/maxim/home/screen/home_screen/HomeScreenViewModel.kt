package com.maxim.home.screen.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.domain.use_case.get_all_jogs.GetAllJogsUseCase
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
    private val getAllJogsUseCase: GetAllJogsUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState.initial())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllJogsUseCase()
                .collect { jogs ->
                    _uiState.update {
                        it.copy(jogList = jogs.toImmutableList())
                    }
                }
        }
    }
}