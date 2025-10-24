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
    fun provideDatabaseHelper(context: Context): AyonDatabaseHelper =
        AyonDatabaseHelper(context)

    @Provides
    @Singleton
    fun provideDatabase(dbHelper: AyonDatabaseHelper): SQLiteDatabase =
        dbHelper.writableDatabase

    @WritableDB
    @Provides
    fun provideWritableDatabase(db: SQLiteDatabase): SQLiteDatabase = db

    @ReadableDB
    @Provides
    fun provideReadableDatabase(db: SQLiteDatabase): SQLiteDatabase = db
}