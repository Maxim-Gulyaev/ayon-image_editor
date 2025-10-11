package com.maxim.domain.use_case.get_all_jogs

import com.maxim.domain.repository.JogRepository
import com.maxim.model.JogDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class GetAllJogsUseCaseImpl @Inject constructor(
    private val repository: JogRepository,
) : GetAllJogsUseCase {

    override fun invoke(): Flow<List<JogDomain>> {
        return repository.getAllJogs()
    }
}