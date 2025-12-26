package com.maxim.domain.use_case.get_dark_theme_config

import com.maxim.model.DarkThemeConfig
import kotlinx.coroutines.flow.Flow

interface GetDarkThemeConfigUseCase {
    operator fun invoke(): Flow<DarkThemeConfig>
}