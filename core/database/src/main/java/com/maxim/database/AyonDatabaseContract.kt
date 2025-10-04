package com.maxim.database

import android.provider.BaseColumns

object AyonDatabaseContract {

    object JogEntry : BaseColumns {
        const val TABLE_NAME = "jog"
        const val COLUMN_NAME_DATE = "date"
        const val COLUMN_NAME_DURATION = "duration"
    }
}