package com.maxim.datastore

import com.maxim.datastore.model.AppLanguageEntity
import com.maxim.datastore.model.DarkThemeConfigEntity
import kotlinx.coroutines.flow.Flow

interface UserPreferencesDataSource {

    val appLanguage: Flow<AppLanguageEntity>
    suspend fun updateAppLanguage(language: AppLanguageEntity)

    val darkThemeConfig: Flow<DarkThemeConfigEntity>
    suspend fun updateDarkThemeConfig(config: DarkThemeConfigEntity)
}