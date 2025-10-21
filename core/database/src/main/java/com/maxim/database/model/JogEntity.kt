package com.maxim.database.model

import com.maxim.model.Jog
import java.time.LocalDate
import kotlin.time.Duration.Companion.seconds

data class JogEntity(
    val date: String,
    val duration: Long,
)

fun JogEntity.toDomain(): Jog {
    return Jog(
        date = LocalDate.parse(date),   // todo handle exception
        duration = duration.seconds
    )
}

