package com.maxim.run.run_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable.isActive
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class RunViewModel @Inject constructor(): ViewModel() {

    private val _uiState: MutableStateFlow<RunUiState> = MutableStateFlow(RunUiState.initial)
    val uiState: StateFlow<RunUiState> = _uiState.asStateFlow()

    private var stopwatchJob: Job? = null

    fun accept(intent: RunScreenIntent) {
        when(intent) {
            RunScreenIntent.OnStartButtonClick -> {
                if (_uiState.value.isStopwatchRunning) {
                    stop()
                } else {
                    start()
                }
                _uiState.update {
                    it.copy(isStopwatchRunning = !it.isStopwatchRunning)
                }
            }
        }
    }

    fun start() {
        stopwatchJob?.cancel()
        stopwatchJob = viewModelScope.launch {
            val start = System.currentTimeMillis()
            while (isActive) {
                val now = System.currentTimeMillis()
                val newValue = now - start
                _uiState.update { it.copy(stopwatchValue = newValue) }
                delay(1000L)
            }
        }
    }

    fun stop() {
        stopwatchJob?.cancel()
    }
}