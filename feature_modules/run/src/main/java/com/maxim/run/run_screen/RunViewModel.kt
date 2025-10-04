package com.maxim.run.run_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxim.domain.use_case.save_jog.SaveJogUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

private const val STOPWATCH_DELAY = 1_000L

class RunViewModel @Inject constructor(
    private val saveJogUseCase: SaveJogUseCase,
): ViewModel() {

    private val _uiState: MutableStateFlow<RunUiState> = MutableStateFlow(RunUiState.initial)
    val uiState: StateFlow<RunUiState> = _uiState.asStateFlow()

    private var stopwatchJob: Job? = null

    fun accept(intent: RunScreenIntent) {
        when (intent) {
            RunScreenIntent.OnStartClick -> if (_uiState.value.isStopwatchRunning) pauseStopwatch() else startStopwatch()
            RunScreenIntent.OnResetClick -> resetStopwatch()
            RunScreenIntent.OnSaveClick -> saveJogUseCase(LocalDateTime.now(), _uiState.value.jogDuration)
        }
    }

    private fun startStopwatch() {
        if (_uiState.value.isStopwatchRunning) return

        launchStopwatchJob()

        _uiState.update { it.copy(isStopwatchRunning = true) }
    }

    private fun pauseStopwatch() {
        stopwatchJob?.cancel()

        _uiState.update {
            it.copy(
                isStopwatchRunning = false,
            )
        }
    }

    private fun resetStopwatch() {
        stopwatchJob?.cancel()

        _uiState.update {
            RunUiState.initial
        }
    }

    private fun launchStopwatchJob() {
        stopwatchJob?.cancel()
        stopwatchJob = viewModelScope.launch {
            while (true) {
                delay(STOPWATCH_DELAY)
                _uiState.update { it.copy(jogDuration = it.jogDuration.plus(1.seconds)) }
            }
        }
    }
}