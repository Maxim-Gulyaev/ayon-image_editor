package com.maxim.domain.use_case.save_jog

import java.time.LocalDateTime
import kotlin.time.Duration

interface SaveJogUseCase {
    operator fun invoke(date: LocalDateTime, duration: Duration)
}