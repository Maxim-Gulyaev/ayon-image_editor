package com.maxim.model

import java.time.LocalDate
import kotlin.time.Duration

data class Jog(
    val date: LocalDate,
    val duration: Duration,
)