package com.maxim.run.run_screen

sealed interface RunScreenIntent {

    data object OnStartClick : RunScreenIntent

    data object OnResetClick : RunScreenIntent
}