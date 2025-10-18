package com.maxim.database

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.maxim.common.di.module.IoDispatcher
import com.maxim.database.AyonDatabaseContract.JogTable
import com.maxim.database.di.ReadableDB
import com.maxim.database.di.WritableDB
import com.maxim.database.model.JogEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
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
) : JogsLocalDataSource {

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
                    add(JogEntity(cursor.getInt(0).toLong(), cursor.getInt(0).toLong()))
                }
            }
        }
}

object DbChangeBus {
    val updates = MutableSharedFlow<String>(extraBufferCapacity = 1)
}

fun notifyTableChanged(table: String) {
    DbChangeBus.updates.tryEmit(table)
}

fun <T> SQLiteDatabase.observeQuery(
    tableName: String,
    query: String,
    mapper: (Cursor) -> T
): Flow<T> = channelFlow {
    fun emitCurrent() {
        val cursor = rawQuery(query, null)
        val mapped = mapper(cursor)
        cursor.close()
        trySend(mapped)
    }

    emitCurrent()

    val job = launch {
        DbChangeBus.updates
            .filter { it == tableName }
            .collect { emitCurrent() }
    }

    awaitClose { job.cancel() }
}
