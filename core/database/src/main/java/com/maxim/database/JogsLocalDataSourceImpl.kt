package com.maxim.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.maxim.common.di.module.IoDispatcher
import com.maxim.database.AyonDatabaseContract.JogTable
import com.maxim.database.di.ReadableDB
import com.maxim.database.di.WritableDB
import com.maxim.database.model.JogEntity
import com.maxim.database.util.notifyTableChanged
import com.maxim.database.util.observeQuery
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.DurationUnit

private const val DATE_COLUMN_INDEX = 0
private const val DURATION_COLUMN_INDEX = 1

class JogsLocalDataSourceImpl @Inject constructor(
    @WritableDB private val writableDB: SQLiteDatabase,
    @ReadableDB private val readableDB: SQLiteDatabase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : JogsLocalDataSource {

    override suspend fun addNewJog(duration: Duration) {
        withContext(ioDispatcher) {
            val values = ContentValues().apply {
                val dateString = LocalDate.now().toString()
                val durationLong = duration.toLong(DurationUnit.SECONDS)
                put(JogTable.COLUMN_NAME_DATE, dateString)
                put(JogTable.COLUMN_NAME_DURATION, durationLong)
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
                    add(
                        JogEntity(
                            cursor.getString(DATE_COLUMN_INDEX),
                            cursor.getInt(DURATION_COLUMN_INDEX).toLong()
                        )
                    )
                }
            }
        }
}
