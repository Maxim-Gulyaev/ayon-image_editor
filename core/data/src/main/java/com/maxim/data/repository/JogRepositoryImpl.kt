package com.maxim.data.repository

import com.maxim.database.JogsLocalDataSource
import com.maxim.domain.repository.JogRepository
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.time.Duration

class JogRepositoryImpl @Inject constructor(
    private val jogsLocalDataSource: JogsLocalDataSource,
): JogRepository {

    override suspend fun addNewJog(date: LocalDateTime, duration: Duration) {
        jogsLocalDataSource.addNewJog(date, duration)
    }
}