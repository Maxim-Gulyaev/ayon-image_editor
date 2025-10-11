package com.maxim.database.model

import com.maxim.model.JogDomain
import java.time.Instant
import java.time.ZoneOffset
import kotlin.time.Duration.Companion.seconds

data class JogEntity(
    val date: Long,
    val duration: Long,
)

fun JogEntity.toDomain(): JogDomain {
    val dateTime = Instant.ofEpochMilli(date)
        .atZone(ZoneOffset.UTC)
        .toLocalDateTime()
    return JogDomain(
        date = dateTime,
        duration = duration.seconds
    )
}

