package com.maxim.run.run_screen

sealed interface RunScreenIntent {

    data object OnStartButtonClick : RunScreenIntent
}