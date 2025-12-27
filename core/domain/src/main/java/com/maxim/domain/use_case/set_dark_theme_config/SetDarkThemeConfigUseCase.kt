package com.maxim.domain.use_case.set_dark_theme_config

import com.maxim.model.DarkThemeConfig

interface SetDarkThemeConfigUseCase {
    suspend operator fun invoke(config: DarkThemeConfig)
}