package com.maxim.database.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ReadableDB

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WritableDB