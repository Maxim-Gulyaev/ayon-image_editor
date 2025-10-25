package com.maxim.common.util

import android.util.Log

fun log(
    message: String = "It works!",
    tag: String = "ayonlog",
) {
    Log.i(tag, message)
}