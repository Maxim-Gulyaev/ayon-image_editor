package com.maxim.run.run_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.common.constants.ZERO_VALUE_LONG
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val STOPWATCH_DELAY = 1_000L

class RunViewModel @Inject constructor(): ViewModel() {

    private val _uiState: MutableStateFlow<RunUiState> = MutableStateFlow(RunUiState.initial)
    val uiState: StateFlow<RunUiState> = _uiState.asStateFlow()

    private var stopwatchJob: Job? = null
    private var startTimeMillis: Long = ZERO_VALUE_LONG
    private var accumulatedTimeMillis: Long = ZERO_VALUE_LONG

    fun accept(intent: RunScreenIntent) {
        when (intent) {
            RunScreenIntent.OnStartClick -> if (_uiState.value.isStopwatchRunning) pauseStopwatch() else startStopwatch()
            RunScreenIntent.OnResetClick -> resetStopwatch()
        }
    }

    private fun startStopwatch() {
        if (_uiState.value.isStopwatchRunning) return

        startTimeMillis = System.currentTimeMillis()
        launchStopwatchJob()

        _uiState.update { it.copy(isStopwatchRunning = true) }
    }

    private fun pauseStopwatch() {
        stopwatchJob?.cancel()
        val now = System.currentTimeMillis()
        accumulatedTimeMillis += now - startTimeMillis

        _uiState.update {
            it.copy(
                isStopwatchRunning = false,
                stopwatchValue = accumulatedTimeMillis
            )
        }
    }

    private fun resetStopwatch() {
        stopwatchJob?.cancel()
        accumulatedTimeMillis = ZERO_VALUE_LONG
        startTimeMillis = ZERO_VALUE_LONG

        _uiState.update {
            RunUiState.initial
        }
    }

    private fun launchStopwatchJob() {
        stopwatchJob?.cancel()
        stopwatchJob = viewModelScope.launch {
            while (true) {
                val now = System.currentTimeMillis()
                val accumulated = accumulatedTimeMillis + (now - startTimeMillis)
                _uiState.update { it.copy(stopwatchValue = accumulated) }
                delay(STOPWATCH_DELAY)
            }
        }
    }
}