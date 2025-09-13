package com.maxim.datastore

import com.maxim.datastore.data.AppLanguage as ProtoAppLanguage
import com.maxim.model.AppLanguage as DomainAppLanguage

fun ProtoAppLanguage.toDomain(): DomainAppLanguage =
    when (this) {
        ProtoAppLanguage.SYSTEM -> DomainAppLanguage.SYSTEM
        ProtoAppLanguage.ENGLISH -> DomainAppLanguage.ENGLISH
        ProtoAppLanguage.SPANISH -> DomainAppLanguage.SPANISH
        ProtoAppLanguage.CHINESE -> DomainAppLanguage.CHINESE
        ProtoAppLanguage.PORTUGUESE -> DomainAppLanguage.PORTUGUESE
        ProtoAppLanguage.UNRECOGNIZED -> DomainAppLanguage.ENGLISH
    }

fun DomainAppLanguage.toProto(): ProtoAppLanguage =
    when (this) {
        DomainAppLanguage.SYSTEM -> ProtoAppLanguage.SYSTEM
        DomainAppLanguage.ENGLISH -> ProtoAppLanguage.ENGLISH
        DomainAppLanguage.SPANISH -> ProtoAppLanguage.SPANISH
        DomainAppLanguage.CHINESE -> ProtoAppLanguage.CHINESE
        DomainAppLanguage.PORTUGUESE -> ProtoAppLanguage.PORTUGUESE
    }

