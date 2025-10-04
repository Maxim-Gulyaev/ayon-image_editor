package com.maxim.database

import java.time.LocalDateTime
import kotlin.time.Duration

interface JogsLocalDataSource {

    fun addNewJog(date: LocalDateTime, duration: Duration)
}