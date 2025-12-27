package com.maxim.domain.repository

import com.maxim.model.AppLanguage
import com.maxim.model.DarkThemeConfig
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getAppLanguage(): Flow<AppLanguage>

    suspend fun setAppLanguage(language: AppLanguage)

    fun getDarkThemeConfig(): Flow<DarkThemeConfig>

    suspend fun setDarkThemeConfig(config: DarkThemeConfig)
}