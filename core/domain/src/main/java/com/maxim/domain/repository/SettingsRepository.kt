package com.maxim.domain.repository

import com.maxim.model.AppLanguageDomain
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getAppLanguage(): Flow<AppLanguageDomain>

    suspend fun setAppLanguage(language: AppLanguageDomain)
}