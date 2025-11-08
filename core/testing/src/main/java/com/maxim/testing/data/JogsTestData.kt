package com.maxim.testing.data

import com.maxim.model.Jog
import java.time.LocalDate
import kotlin.time.Duration.Companion.minutes

val testJog = Jog(LocalDate.of(2025, 1, 1), 10.minutes)

val testJogs: List<Jog> = listOf(testJog, testJog, testJog)