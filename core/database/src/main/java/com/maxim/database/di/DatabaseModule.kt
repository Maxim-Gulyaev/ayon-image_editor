package com.maxim.database.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.maxim.database.AyonDatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ReadableDB

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WritableDB

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