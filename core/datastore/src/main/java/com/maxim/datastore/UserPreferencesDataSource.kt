package com.maxim.datastore

import androidx.datastore.core.DataStore
import com.maxim.datastore.data.UserPreferences
import com.maxim.model.AppLanguage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataSource @Inject constructor(
    private val dataStore: DataStore<UserPreferences>
) {
    val appLanguage: Flow<AppLanguage> = dataStore.data
        .map { it.appLanguage.toDomain() }

    suspend fun updateAppLanguage(language: AppLanguage) {
        dataStore.updateData { prefs ->
            prefs.toBuilder()
                .setAppLanguage(language.toProto())
                .build()
        }
    }
}
