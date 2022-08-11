package com.joseph.core_network_impl

import com.joseph.core_network_api.ProvideConverterFactory
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

class ProvideConverterFactoryImpl : ProvideConverterFactory {

    override fun convertorFactory(): Converter.Factory = GsonConverterFactory.create()

}