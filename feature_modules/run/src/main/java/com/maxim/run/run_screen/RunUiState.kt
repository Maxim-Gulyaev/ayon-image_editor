package com.maxim.run.run_screen

import androidx.compose.runtime.Immutable
import kotlin.time.Duration

@Immutable
data class RunUiState(
    val jogDuration: Duration,
    val isStopwatchRunning: Boolean,
) {
    companion object {
        val initial = RunUiState(
            jogDuration = Duration.ZERO,
            isStopwatchRunning = false,
        )
    }
}
