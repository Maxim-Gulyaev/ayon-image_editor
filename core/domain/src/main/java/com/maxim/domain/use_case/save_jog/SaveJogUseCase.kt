package com.maxim.domain.use_case.save_jog

import kotlin.time.Duration

interface SaveJogUseCase {
    suspend operator fun invoke(duration: Duration)
}