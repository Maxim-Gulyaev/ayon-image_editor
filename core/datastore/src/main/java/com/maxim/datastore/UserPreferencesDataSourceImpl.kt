package com.maxim.datastore

import androidx.datastore.core.DataStore
import com.maxim.datastore.data.UserPreferences
import com.maxim.datastore.model.AppLanguageEntity
import com.maxim.datastore.model.DarkThemeConfigEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<UserPreferences>
): UserPreferencesDataSource {

    override val appLanguage: Flow<AppLanguageEntity> = dataStore.data
        .map { it.appLanguage.toDomain() }

    override suspend fun updateAppLanguage(language: AppLanguageEntity) {
        dataStore.updateData { prefs ->
            prefs.toBuilder()
                .setAppLanguage(language.toProto())
                .build()
        }
    }


    override val darkThemeConfig: Flow<DarkThemeConfigEntity> = dataStore.data
        .map { it.darkThemeConfig.toDomain() }

    override suspend fun updateDarkThemeConfig(config: DarkThemeConfigEntity) {
        dataStore.updateData { prefs ->
            prefs.toBuilder()
                .setDarkThemeConfig(config.toProto())
                .build()
        }
    }
}
