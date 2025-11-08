package com.maxim.common.util

import android.util.Log

private const val TAG = "ayonlog"

interface Logger {
    fun e(tag: String = TAG, message: String = "Error!", throwable: Throwable? = null)
    fun d(tag: String = TAG, message: String = "This works!")
}

class AyonLog: Logger {

    override fun e(tag: String, message: String, throwable: Throwable?) {
        Log.e(tag, message, throwable)
    }

    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}

object NoopLog: Logger {

    override fun e(tag: String, message: String, throwable: Throwable?) = Unit

    override fun d(tag: String, message: String) = Unit
}