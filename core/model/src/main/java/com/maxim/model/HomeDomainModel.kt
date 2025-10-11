package com.maxim.model

import java.time.LocalDateTime
import kotlin.time.Duration

data class JogDomain(
    val date: LocalDateTime,
    val duration: Duration,
)