package com.maxim.domain.repository

import com.maxim.model.Jog
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import kotlin.time.Duration

interface JogRepository {

    suspend fun addNewJog(duration: Duration)

    fun getAllJogs(): Flow<List<Jog>>
}