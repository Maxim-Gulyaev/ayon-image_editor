package com.maxim.database.model

import com.maxim.model.JogDomain
import java.time.LocalDate
import kotlin.time.Duration.Companion.seconds

data class JogEntity(
    val date: String,
    val duration: Long,
)

fun JogEntity.toDomain(): JogDomain {
    return JogDomain(
        date = LocalDate.parse(date),   // todo handle exception
        duration = duration.seconds
    )
}

