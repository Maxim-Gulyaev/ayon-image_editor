package com.maxim.domain.use_case.get_all_jogs

import com.maxim.domain.repository.JogRepository
import com.maxim.model.Jog
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllJogsUseCaseImpl @Inject constructor(
    private val repository: JogRepository,
) : GetAllJogsUseCase {

    override fun invoke(): Flow<List<Jog>> {
        return repository.getAllJogs()
    }
}