package com.maxim.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.maxim.common.di.module.IoDispatcher
import com.maxim.database.AyonDatabaseContract.JogEntry.TABLE_NAME
import com.maxim.database.di.WritableDB
import com.maxim.database.model.JogEntity
import com.maxim.database.model.toDomain
import com.maxim.model.JogDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

class JogsLocalDataSourceImpl @Inject constructor(
    @WritableDB private val writableDB: SQLiteDatabase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : JogsLocalDataSource {

    override suspend fun addNewJog(date: LocalDateTime, duration: Duration) {
        withContext(ioDispatcher) {
            val values = ContentValues().apply {
                val millis = date
                    .atZone(ZoneOffset.UTC)
                    .toInstant()
                    .toEpochMilli()
                put(AyonDatabaseContract.JogEntry.COLUMN_NAME_DATE, millis)
                put(AyonDatabaseContract.JogEntry.COLUMN_NAME_DURATION, duration.toLong(DurationUnit.SECONDS))
            }
            writableDB.insert(TABLE_NAME, null, values)
        }
    }

    override fun getAllJogs(): Flow<List<JogEntity>> {
        return flow { emit(listOf(JogEntity(64464747747, 65474))) }
    }
}