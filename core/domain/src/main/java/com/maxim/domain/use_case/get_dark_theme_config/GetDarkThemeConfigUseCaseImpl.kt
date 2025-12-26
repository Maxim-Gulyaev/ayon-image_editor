package com.maxim.domain.use_case.get_dark_theme_config

import com.maxim.domain.repository.SettingsRepository
import com.maxim.model.DarkThemeConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDarkThemeConfigUseCaseImpl @Inject constructor(
    private val repository: SettingsRepository,
) : GetDarkThemeConfigUseCase {

    override fun invoke(): Flow<DarkThemeConfig> = repository.getDarkThemeConfig()
}