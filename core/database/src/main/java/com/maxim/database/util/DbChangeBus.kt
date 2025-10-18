package com.maxim.database.util

import kotlinx.coroutines.flow.MutableSharedFlow

object DbChangeBus {
    val updates = MutableSharedFlow<String>(extraBufferCapacity = 1)
}