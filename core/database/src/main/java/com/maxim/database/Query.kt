package com.maxim.database

import android.provider.BaseColumns
import com.maxim.database.AyonDatabaseContract.JogEntry.COLUMN_NAME_DATE
import com.maxim.database.AyonDatabaseContract.JogEntry.COLUMN_NAME_DURATION
import com.maxim.database.AyonDatabaseContract.JogEntry.TABLE_NAME

internal const val SQL_CREATE_JOG_TABLE = """
            CREATE TABLE $TABLE_NAME (
                ${BaseColumns._ID} INTEGER PRIMARY KEY,
                $COLUMN_NAME_DATE INTEGER NOT NULL,
                $COLUMN_NAME_DURATION INTEGER NOT NULL
            )
        """

internal const val SQL_DROP_JOG_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"