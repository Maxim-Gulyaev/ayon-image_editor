package com.maxim.datastore

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.maxim.datastore.data.AppLanguage
import com.maxim.datastore.data.UserPreferences
import java.io.InputStream
import java.io.OutputStream

private const val USER_PREFS_DATASTORE_FILE_NAME = "user_preferences.pb"

object UserPreferencesSerializer : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences = UserPreferences
        .newBuilder()
        .setAppLanguage(AppLanguage.CHINESE)
        .build()

    override suspend fun readFrom(input: InputStream): UserPreferences {
        try {
            return UserPreferences.parseFrom(input)
        } catch (e: Exception) {
            throw CorruptionException("Cannot read proto.", e)
        }
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) =
        t.writeTo(output)
}

val Context.userPrefsDataStore: DataStore<UserPreferences> by dataStore(
    fileName = USER_PREFS_DATASTORE_FILE_NAME,
    serializer = UserPreferencesSerializer
)
