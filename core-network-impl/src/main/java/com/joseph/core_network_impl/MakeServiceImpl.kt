package com.joseph.core_network_impl

import com.joseph.core_network_api.MakeService
import com.joseph.core_network_api.ProvideRetrofitBuilder

open class MakeServiceImpl(
    private val retrofitBuilder: ProvideRetrofitBuilder
) : MakeService {

    private val retrofit by lazy(LazyThreadSafetyMode.NONE) {
        retrofitBuilder
            .provideRetrofitBuilder()
            .baseUrl(baseUrl())
            .build()
    }

    override fun <T> service(clasz: Class<T>): T = retrofit.create(clasz)

    protected open fun baseUrl(): String = "https://parseapi.back4app.com/"
}