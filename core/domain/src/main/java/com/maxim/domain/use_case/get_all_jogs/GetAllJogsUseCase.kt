package com.maxim.domain.use_case.get_all_jogs

import com.maxim.model.Jog
import kotlinx.coroutines.flow.Flow

interface GetAllJogsUseCase {
    operator fun invoke(): Flow<List<Jog>>
}