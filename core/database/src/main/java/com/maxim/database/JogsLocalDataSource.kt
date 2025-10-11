package com.maxim.database

import com.maxim.database.model.JogEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import kotlin.time.Duration

interface JogsLocalDataSource {

    suspend fun addNewJog(date: LocalDateTime, duration: Duration)

    fun getAllJogs(): Flow<List<JogEntity>>
}