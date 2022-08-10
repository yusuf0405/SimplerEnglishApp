package com.joseph.core_mvvm.data

import retrofit2.Retrofit

interface ProvideRetrofitBuilder {

    fun provideRetrofitBuilder(): Retrofit.Builder

    class Base(
        private val provideConverterFactory: ProvideConverterFactory,
        private val provideOkHttpClientBuilder: ProvideOkHttpClientBuilder
    ) : ProvideRetrofitBuilder {
        override fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
                .addConverterFactory(provideConverterFactory.convertorFactory())
                .client(provideOkHttpClientBuilder.httpClientBuilder())
    }
}