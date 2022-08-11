package com.joseph.core_network_impl.di

import com.joseph.core_network_api.*
import com.joseph.core_network_impl.data.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideMakeService(
        retrofitBuilder: ProvideRetrofitBuilder
    ): MakeService = MakeServiceImpl(retrofitBuilder = retrofitBuilder)

    @Provides
    @Singleton
    fun provideProvideConverterFactory(): ProvideConverterFactory = ProvideConverterFactoryImpl()


    @Provides
    @Singleton
    fun provideProvideInterceptorDebug(): ProvideInterceptor = ProvideInterceptorImpl.Debug()

    @Provides
    @Singleton
    fun provideProvideOkHttpClientBuilder(
        provideInterceptor: ProvideInterceptor,
    ): ProvideOkHttpClientBuilder =
        ProvideOkHttpClientBuilderImpl(provideInterceptor = provideInterceptor)

    @Provides
    @Singleton
    fun provideProvideRetrofitBuilder(
        provideConverterFactory: ProvideConverterFactory,
        provideOkHttpClientBuilder: ProvideOkHttpClientBuilder
    ): ProvideRetrofitBuilder = ProvideRetrofitBuilderImpl(
        provideConverterFactory = provideConverterFactory,
        provideOkHttpClientBuilder = provideOkHttpClientBuilder
    )
}