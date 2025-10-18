package com.maxim.database.base

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.maxim.database.util.DbChangeBus
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

abstract class BaseLocalDataSource {

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
}