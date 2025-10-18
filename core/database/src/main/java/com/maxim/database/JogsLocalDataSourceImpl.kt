package com.maxim.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.maxim.common.di.module.IoDispatcher
import com.maxim.database.AyonDatabaseContract.JogTable
import com.maxim.database.base.BaseLocalDataSource
import com.maxim.database.di.ReadableDB
import com.maxim.database.di.WritableDB
import com.maxim.database.model.JogEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.DurationUnit

class JogsLocalDataSourceImpl @Inject constructor(
    @WritableDB private val writableDB: SQLiteDatabase,
    @ReadableDB private val readableDB: SQLiteDatabase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : JogsLocalDataSource, BaseLocalDataSource() {

    override suspend fun addNewJog(date: LocalDateTime, duration: Duration) {
        withContext(ioDispatcher) {
            val values = ContentValues().apply {
                val millis = date
                    .atZone(ZoneOffset.UTC)
                    .toInstant()
                    .toEpochMilli()
                put(JogTable.COLUMN_NAME_DATE, millis)
                put(JogTable.COLUMN_NAME_DURATION, duration.toLong(DurationUnit.SECONDS))
            }
            writableDB.insert(JogTable.TABLE_NAME, null, values)
            notifyTableChanged(JogTable.TABLE_NAME)
        }
    }

    override fun getAllJogs(): Flow<List<JogEntity>> =
        readableDB.observeQuery(
            tableName = JogTable.TABLE_NAME,
            query = SQL_SELECT_ALL_JOGS
        ) { cursor ->
            buildList {
                while (cursor.moveToNext()) {
                    add(JogEntity(cursor.getInt(0).toLong(), cursor.getInt(1).toLong()))
                }
            }
        }
}
