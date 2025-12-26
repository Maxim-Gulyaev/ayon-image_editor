package com.maxim.data.repository

import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.datastore.model.toData
import com.maxim.datastore.model.toDomain
import com.maxim.model.AppLanguage
import com.maxim.domain.repository.SettingsRepository
import com.maxim.model.DarkThemeConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    val userPreferencesDataSource: UserPreferencesDataSource,
): SettingsRepository {

    override fun getAppLanguage(): Flow<AppLanguage> =
        userPreferencesDataSource.appLanguage.map { it.toDomain() }

    override suspend fun setAppLanguage(language: AppLanguage) {
        userPreferencesDataSource.updateAppLanguage(language.toData())
    }

    override fun getDarkThemeConfig(): Flow<DarkThemeConfig> =
        userPreferencesDataSource.darkThemeConfig.map { it.toDomain() }
}