package com.maxim.domain.use_case.set_app_language

import com.maxim.model.AppLanguage

interface SetAppLanguageUseCase {
    suspend operator fun invoke(language: AppLanguage)
}