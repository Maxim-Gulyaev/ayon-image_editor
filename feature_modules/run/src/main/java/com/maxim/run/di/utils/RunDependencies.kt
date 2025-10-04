package com.maxim.run.di.utils

import com.maxim.domain.use_case.save_jog.SaveJogUseCase

interface RunDependencies {
    fun saveJogUseCase(): SaveJogUseCase
}