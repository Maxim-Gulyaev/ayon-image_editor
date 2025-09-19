package com.maxim.run.run_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class RunViewModel @Inject constructor(): ViewModel() {

    private val _uiState: MutableStateFlow<RunUiState> = MutableStateFlow(RunUiState.initial)
    val uiState: StateFlow<RunUiState> = _uiState.asStateFlow()

    fun accept(intent: RunScreenIntent) {
        when(intent) {
            RunScreenIntent.OnStartButtonClick -> {
                _uiState.update {
                    it.copy(isStopwatchRunning = !it.isStopwatchRunning)
                }
            }
        }
    }
}