package com.maxim.domain.use_case.get_app_language

import com.maxim.domain.model.settings.AppLanguageDomain
import kotlinx.coroutines.flow.Flow

interface GetAppLanguageUseCase {
    operator fun invoke(): Flow<AppLanguageDomain>
}