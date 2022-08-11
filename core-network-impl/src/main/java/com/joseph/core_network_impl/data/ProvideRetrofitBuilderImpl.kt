package com.joseph.core_network_impl.data

import com.joseph.core_network_api.ProvideConverterFactory
import com.joseph.core_network_api.ProvideOkHttpClientBuilder
import com.joseph.core_network_api.ProvideRetrofitBuilder
import retrofit2.Retrofit

class ProvideRetrofitBuilderImpl(
    private val provideConverterFactory: ProvideConverterFactory,
    private val provideOkHttpClientBuilder: ProvideOkHttpClientBuilder
) : ProvideRetrofitBuilder {
    override fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(provideConverterFactory.convertorFactory())
        .client(provideOkHttpClientBuilder.httpClientBuilder())
}