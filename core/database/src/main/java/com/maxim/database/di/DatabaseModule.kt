package com.maxim.database.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.maxim.database.AyonDatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabaseHelper(context: Context): AyonDatabaseHelper {
        return AyonDatabaseHelper(context)
    }

    @WritableDB
    @Provides
    fun provideWritableDatabase(dbHelper: AyonDatabaseHelper): SQLiteDatabase {
        return dbHelper.writableDatabase
    }

    @ReadableDB
    @Provides
    fun provideReadableDatabase(dbHelper: AyonDatabaseHelper): SQLiteDatabase {
        return dbHelper.readableDatabase
    }
}