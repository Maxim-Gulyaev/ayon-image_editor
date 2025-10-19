package com.maxim.database

import android.provider.BaseColumns
import com.maxim.database.AyonDatabaseContract.JogTable.COLUMN_NAME_DATE
import com.maxim.database.AyonDatabaseContract.JogTable.COLUMN_NAME_DURATION
import com.maxim.database.AyonDatabaseContract.JogTable.TABLE_NAME

internal const val SQL_CREATE_JOG_TABLE = """
            CREATE TABLE $TABLE_NAME (
                ${BaseColumns._ID} INTEGER PRIMARY KEY,
                $COLUMN_NAME_DATE STRING NOT NULL,
                $COLUMN_NAME_DURATION INTEGER NOT NULL
            )
        """

internal const val SQL_DROP_JOG_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

internal const val SQL_SELECT_ALL_JOGS = """
            SELECT 
                $COLUMN_NAME_DATE, 
                $COLUMN_NAME_DURATION
            FROM $TABLE_NAME
        """