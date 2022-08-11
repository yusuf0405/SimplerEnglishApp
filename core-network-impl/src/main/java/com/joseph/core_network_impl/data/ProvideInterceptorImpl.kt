package com.joseph.core_network_impl.data

import com.joseph.core_network_api.ProvideInterceptor
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

abstract class ProvideInterceptorImpl(
    private val loggingLevel: HttpLoggingInterceptor.Level
) : ProvideInterceptor {

    private fun applicationId(): String = "Kl1kjBC3pgHscO0CRN9DVFzeO1VJUXPTrkzHqKhI"

    private fun restApiKey(): String = "ISIIAx980AclQwaLDZTqlCSCHY0wt15qN0e5wPZd"

    private fun contentType(): String = "application/json"

    override fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = loggingLevel
    }

    override fun requestInterceptor(): Interceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .cacheControl(CacheControl.Builder().maxAge(0, TimeUnit.SECONDS).build())
            .addHeader("X-Parse-Application-Id", applicationId())
            .addHeader("X-Parse-REST-API-Key", restApiKey())
            .addHeader("Content-Type", contentType())
            .build()
        return@Interceptor chain.proceed(request)

    }

    class Debug : ProvideInterceptorImpl(loggingLevel = HttpLoggingInterceptor.Level.BODY)

    class Release : ProvideInterceptorImpl(loggingLevel = HttpLoggingInterceptor.Level.NONE)
}

