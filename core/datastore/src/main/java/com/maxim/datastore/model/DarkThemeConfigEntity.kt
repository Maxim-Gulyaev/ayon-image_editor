package com.maxim.datastore.model

import com.maxim.model.DarkThemeConfig

enum class DarkThemeConfigEntity {
    DARK,
    LIGHT,
    SYSTEM,
}

fun DarkThemeConfigEntity.toDomain() =
    when (this) {
        DarkThemeConfigEntity.DARK -> DarkThemeConfig.DARK
        DarkThemeConfigEntity.LIGHT -> DarkThemeConfig.LIGHT
        DarkThemeConfigEntity.SYSTEM -> DarkThemeConfig.SYSTEM
    }

fun DarkThemeConfig.toData() =
    when (this) {
        DarkThemeConfig.DARK -> DarkThemeConfigEntity.DARK
        DarkThemeConfig.LIGHT -> DarkThemeConfigEntity.LIGHT
        DarkThemeConfig.SYSTEM -> DarkThemeConfigEntity.SYSTEM
    }