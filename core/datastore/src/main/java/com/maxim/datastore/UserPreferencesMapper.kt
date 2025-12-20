package com.maxim.datastore

import com.maxim.datastore.data.AppLanguage as ProtoAppLanguage
import com.maxim.datastore.model.AppLanguageEntity as DomainAppLanguage
import com.maxim.datastore.data.DarkThemeConfig as ProtoDarkThemeConfig
import com.maxim.datastore.model.DarkThemeConfigEntity as DomainDarkThemeConfig

fun ProtoAppLanguage.toDomain(): DomainAppLanguage =
    when (this) {
        ProtoAppLanguage.SYSTEM -> DomainAppLanguage.SYSTEM
        ProtoAppLanguage.ENGLISH -> DomainAppLanguage.ENGLISH
        ProtoAppLanguage.SPANISH -> DomainAppLanguage.SPANISH
        ProtoAppLanguage.CHINESE -> DomainAppLanguage.CHINESE
        ProtoAppLanguage.PORTUGUESE -> DomainAppLanguage.PORTUGUESE
        ProtoAppLanguage.RUSSIAN -> DomainAppLanguage.RUSSIAN
        ProtoAppLanguage.UNRECOGNIZED -> DomainAppLanguage.ENGLISH
    }

fun DomainAppLanguage.toProto(): ProtoAppLanguage =
    when (this) {
        DomainAppLanguage.SYSTEM -> ProtoAppLanguage.SYSTEM
        DomainAppLanguage.ENGLISH -> ProtoAppLanguage.ENGLISH
        DomainAppLanguage.SPANISH -> ProtoAppLanguage.SPANISH
        DomainAppLanguage.CHINESE -> ProtoAppLanguage.CHINESE
        DomainAppLanguage.PORTUGUESE -> ProtoAppLanguage.PORTUGUESE
        DomainAppLanguage.RUSSIAN -> ProtoAppLanguage.RUSSIAN
    }

fun ProtoDarkThemeConfig.toDomain(): DomainDarkThemeConfig =
    when (this) {
        ProtoDarkThemeConfig.DARK -> DomainDarkThemeConfig.DARK
        ProtoDarkThemeConfig.LIGHT -> DomainDarkThemeConfig.LIGHT
        ProtoDarkThemeConfig.FOLLOW_BY_SYSTEM -> DomainDarkThemeConfig.SYSTEM
        ProtoDarkThemeConfig.UNRECOGNIZED -> DomainDarkThemeConfig.SYSTEM
    }

fun DomainDarkThemeConfig.toProto(): ProtoDarkThemeConfig =
    when (this) {
        DomainDarkThemeConfig.DARK -> ProtoDarkThemeConfig.DARK
        DomainDarkThemeConfig.LIGHT -> ProtoDarkThemeConfig.LIGHT
        DomainDarkThemeConfig.SYSTEM -> ProtoDarkThemeConfig.FOLLOW_BY_SYSTEM
    }


