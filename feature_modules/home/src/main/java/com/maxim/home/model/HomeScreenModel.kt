package com.maxim.home.model

import com.maxim.model.JogDomain
import java.time.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

data class JogUi(
    val date: LocalDateTime,
    val duration: Duration,
) {
    companion object {
        // todo remove this
        fun mock() =
            JogUi(
                date = LocalDateTime.of(2025, 7, 10, 13, 35),
                duration = 20.minutes,
            )
    }
}

fun JogDomain.toUi() = JogUi(
    date = date,
    duration = duration,
)