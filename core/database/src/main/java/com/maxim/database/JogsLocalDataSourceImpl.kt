package com.maxim.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.maxim.database.AyonDatabaseContract.JogEntry.TABLE_NAME
import com.maxim.database.di.WritableDB
import java.time.LocalDateTime
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.DurationUnit

class JogsLocalDataSourceImpl @Inject constructor(
    @WritableDB private val writableDB: SQLiteDatabase,
) : JogsLocalDataSource {

    override fun addNewJog(date: LocalDateTime, duration: Duration) {
        val values = ContentValues().apply {
            val millis = date
                .atZone(java.time.ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli()
            put(AyonDatabaseContract.JogEntry.COLUMN_NAME_DATE, millis)
            put(AyonDatabaseContract.JogEntry.COLUMN_NAME_DURATION, duration.toLong(DurationUnit.SECONDS))
        }
        writableDB.insert(TABLE_NAME, null, values)
    }
}