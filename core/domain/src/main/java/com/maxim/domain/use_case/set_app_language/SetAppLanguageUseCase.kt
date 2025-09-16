package com.maxim.domain.use_case.set_app_language

import com.maxim.domain.model.settings.AppLanguageDomain

interface SetAppLanguageUseCase {
    suspend operator fun invoke(language: AppLanguageDomain)
}