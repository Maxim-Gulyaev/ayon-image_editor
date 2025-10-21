package com.maxim.domain.use_case.set_app_language

import com.maxim.domain.repository.SettingsRepository
import com.maxim.model.AppLanguage
import javax.inject.Inject

class SetAppLanguageUseCaseImpl @Inject constructor(
    private val repository: SettingsRepository,
) : SetAppLanguageUseCase {

    override suspend fun invoke(language: AppLanguage) {
        repository.setAppLanguage(language)
    }
}