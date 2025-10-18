package com.maxim.database

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.maxim.common.di.module.IoDispatcher
import com.maxim.database.AyonDatabaseContract.JogEntry.TABLE_NAME
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
    private val ayonDatabaseHelper: AyonDatabaseHelper,
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
                put(AyonDatabaseContract.JogEntry.COLUMN_NAME_DATE, millis)
                put(AyonDatabaseContract.JogEntry.COLUMN_NAME_DURATION, duration.toLong(DurationUnit.SECONDS))
            }
            writableDB.insert(TABLE_NAME, null, values)
            notifyTableChanged("jog")
        }
    }

    override fun getAllJogs(): Flow<List<JogEntity>> {
        //return flow { emit(listOf(JogEntity(64464747747, 65474))) }
        return ayonDatabaseHelper.observeQuery<List<JogEntity>>(
            tableName = "jog",
            query = "SELECT date, duration FROM jog"
        ) { cursor ->
            buildList {
                while (cursor.moveToNext()) {
                    add(JogEntity(cursor.getInt(0).toLong(), cursor.getInt(0).toLong()))
                }
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

fun <T> AyonDatabaseHelper.observeQuery(
    tableName: String,
    query: String,
    mapper: (Cursor) -> T
): Flow<T> = channelFlow {
    val db = readableDatabase

    fun emitCurrent() {
        val cursor = db.rawQuery(query, null)
        val mapped = mapper(cursor)
        cursor.close()
        trySend(mapped)
    }

    // первый запуск
    emitCurrent()

    // слушаем изменения в таблице
    val job = launch {
        DbChangeBus.updates
            .filter { it == tableName }
            .collect { emitCurrent() }
    }

    awaitClose { job.cancel() }
}
