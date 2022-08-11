package com.joseph.core_network_api

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

interface ProvideConverterFactory {

    fun convertorFactory(): Converter.Factory

}