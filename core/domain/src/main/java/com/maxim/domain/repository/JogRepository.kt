package com.maxim.domain.repository

import java.time.LocalDateTime
import kotlin.time.Duration

interface JogRepository {

    fun addNewJog(date: LocalDateTime, duration: Duration)
}