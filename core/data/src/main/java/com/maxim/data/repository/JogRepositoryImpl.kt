package com.maxim.data.repository

import com.maxim.database.JogsLocalDataSource
import com.maxim.database.model.toDomain
import com.maxim.domain.repository.JogRepository
import com.maxim.model.JogDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class JogRepositoryImpl @Inject constructor(
    private val jogsLocalDataSource: JogsLocalDataSource,
): JogRepository {

    override suspend fun addNewJog(date: LocalDateTime, duration: Duration) {
        jogsLocalDataSource.addNewJog(date, duration)
    }

    override fun getAllJogs(): Flow<List<JogDomain>> {
        return jogsLocalDataSource.getAllJogs()
            .map { jogs -> jogs.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)
    }
}