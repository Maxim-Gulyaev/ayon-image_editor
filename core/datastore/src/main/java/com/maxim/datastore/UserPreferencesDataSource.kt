package com.maxim.datastore

import com.maxim.datastore.model.AppLanguageEntity
import kotlinx.coroutines.flow.Flow

interface UserPreferencesDataSource {

    val appLanguage: Flow<AppLanguageEntity>

    suspend fun updateAppLanguage(language: AppLanguageEntity)
}