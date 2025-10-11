package com.maxim.domain.use_case.get_app_language

import com.maxim.model.AppLanguageDomain
import kotlinx.coroutines.flow.Flow

interface GetAppLanguageUseCase {
    suspend operator fun invoke(): Flow<AppLanguageDomain>
}