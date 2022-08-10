package com.joseph.core_mvvm.data

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

interface ProvideConverterFactory {

    fun convertorFactory(): Converter.Factory

    class Base : ProvideConverterFactory {

        override fun convertorFactory(): Converter.Factory = GsonConverterFactory.create()

    }
}