package com.joseph.core_mvvm.data

import okhttp3.logging.HttpLoggingInterceptor

interface ProvideInterceptor {

    fun loggingInterceptor(): HttpLoggingInterceptor

    abstract class Abstract(
        private val loggingLevel: HttpLoggingInterceptor.Level
    ) : ProvideInterceptor {

        override fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = loggingLevel
        }

    }

    class Debug : Abstract(loggingLevel = HttpLoggingInterceptor.Level.BODY)

    class Release : Abstract(loggingLevel = HttpLoggingInterceptor.Level.NONE)
}