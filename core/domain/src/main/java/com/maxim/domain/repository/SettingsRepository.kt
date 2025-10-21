package com.maxim.domain.repository

import com.maxim.model.AppLanguage
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getAppLanguage(): Flow<AppLanguage>

    suspend fun setAppLanguage(language: AppLanguage)
}