package com.maxim.domain.use_case.save_jog

import com.maxim.domain.repository.JogRepository
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.time.Duration

class SaveJogUseCaseImpl @Inject constructor(
    private val repository: JogRepository,
) : SaveJogUseCase {

    override suspend fun invoke(date: LocalDateTime, duration: Duration) {
        repository.addNewJog(date, duration)
    }
}