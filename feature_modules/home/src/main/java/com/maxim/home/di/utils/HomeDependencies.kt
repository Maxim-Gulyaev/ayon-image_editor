package com.maxim.home.di.utils

import com.maxim.domain.use_case.get_all_jogs.GetAllJogsUseCase

interface HomeDependencies {
    fun getAllJogsUseCase(): GetAllJogsUseCase
}