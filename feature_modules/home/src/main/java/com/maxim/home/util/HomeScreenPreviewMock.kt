package com.maxim.home.util

import com.maxim.home.screen.home_screen.HomeScreenUiState
import com.maxim.model.Jog
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDate
import kotlin.time.Duration.Companion.seconds

fun jogMock() =
    Jog(
        date = LocalDate.of(2025, 7, 10),
        duration = 358944.seconds,
    )

fun homeScreenUiStateMock() =
    HomeScreenUiState.Success(
        jogList = persistentListOf(
            jogMock(),
            jogMock(),
            jogMock(),
            jogMock(),
            jogMock(),
            jogMock(),
        )
    )