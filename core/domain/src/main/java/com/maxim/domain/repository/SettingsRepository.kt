package com.maxim.domain.repository

import com.maxim.domain.model.settings.AppLanguageDomain
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getAppLanguage(): Flow<AppLanguageDomain>
}