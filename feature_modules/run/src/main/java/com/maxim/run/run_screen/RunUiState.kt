package com.maxim.run.run_screen

import androidx.compose.runtime.Immutable
import com.maxim.common.constants.ZERO_VALUE_LONG

@Immutable
data class RunUiState(
    val stopwatchValue: Long,
    val isStopwatchRunning: Boolean,
) {
    companion object {
        val initial = RunUiState(
            stopwatchValue = ZERO_VALUE_LONG,
            isStopwatchRunning = false,
        )
    }
}
