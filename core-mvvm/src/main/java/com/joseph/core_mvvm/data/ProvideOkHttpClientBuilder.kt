package com.joseph.core_mvvm.data

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

interface ProvideOkHttpClientBuilder {

    fun httpClientBuilder(): OkHttpClient

    abstract class Abstract(
        private val provideInterceptor: ProvideInterceptor,
        private val timeOutSeconds: Long = 60L
    ) : ProvideOkHttpClientBuilder {

        override fun httpClientBuilder(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(provideInterceptor.loggingInterceptor())
                .connectTimeout(timeOutSeconds, TimeUnit.SECONDS)
                .readTimeout(timeOutSeconds, TimeUnit.SECONDS)
                .build()

    }
}