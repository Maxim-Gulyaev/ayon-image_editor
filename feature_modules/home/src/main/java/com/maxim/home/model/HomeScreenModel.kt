package com.maxim.home.model

import java.time.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

data class JogUi(
    val date: LocalDateTime,
    val duration: Duration,
    val id: String? = null,
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