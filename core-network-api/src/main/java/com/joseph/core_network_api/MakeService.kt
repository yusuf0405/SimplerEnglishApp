package com.joseph.core_network_api

interface MakeService {

    fun <T> service(clasz: Class<T>): T

}