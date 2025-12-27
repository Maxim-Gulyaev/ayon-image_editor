package com.maxim.domain.use_case.set_dark_theme_config

import com.maxim.domain.repository.SettingsRepository
import com.maxim.model.DarkThemeConfig
import javax.inject.Inject

class SetDarkThemeConfigUseCaseImpl @Inject constructor(
    private val repository: SettingsRepository,
) : SetDarkThemeConfigUseCase {

    override suspend fun invoke(config: DarkThemeConfig) {
        repository.setDarkThemeConfig(config)
    }
}