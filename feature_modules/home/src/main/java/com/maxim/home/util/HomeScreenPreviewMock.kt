package com.maxim.home.util

import com.maxim.home.screen.home_screen.HomeScreenUiState
import com.maxim.model.Jog
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDate
import kotlin.time.Duration.Companion.minutes

fun jogMock() =
    Jog(
        date = LocalDate.of(2025, 7, 10),
        duration = 20.minutes,
    )

fun homeScreenUiStateMock() =
    HomeScreenUiState(
        jogList = persistentListOf(
            jogMock(),
            jogMock(),
            jogMock(),
            jogMock(),
            jogMock(),
            jogMock(),
        )
    )