package com.joseph.core_network_api

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

interface ProvideInterceptor {

    fun loggingInterceptor(): HttpLoggingInterceptor

    fun requestInterceptor(): Interceptor

}