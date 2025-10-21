package com.maxim.home.model

import com.maxim.model.Jog
import java.time.LocalDate
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

data class JogUi(
    val date: LocalDate,
    val duration: Duration,
) {
    companion object {
        // todo remove this
        fun mock() =
            JogUi(
                date = LocalDate.of(2025, 7, 10),
                duration = 20.minutes,
            )
    }
}

fun Jog.toUi() = JogUi(
    date = date,
    duration = duration,
)