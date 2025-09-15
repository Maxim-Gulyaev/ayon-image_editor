package com.maxim.datastore

import com.maxim.model.AppLanguage
import kotlinx.coroutines.flow.Flow

interface UserPreferencesDataSource {

    val appLanguage: Flow<AppLanguage>

    suspend fun updateAppLanguage(language: AppLanguage)
}