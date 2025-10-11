package com.maxim.data.repository

import com.maxim.data.mapper.toData
import com.maxim.data.mapper.toDomain
import com.maxim.datastore.UserPreferencesDataSource
import com.maxim.model.AppLanguageDomain
import com.maxim.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    val userPreferencesDataSource: UserPreferencesDataSource,
): SettingsRepository {

    override fun getAppLanguage(): Flow<AppLanguageDomain> =
        userPreferencesDataSource.appLanguage.map { it.toDomain() }

    override suspend fun setAppLanguage(language: AppLanguageDomain) {
        userPreferencesDataSource.updateAppLanguage(language.toData())
    }
}