package com.joseph.core_mvvm.data

interface CloudDataSource {

    suspend fun <T> handle(block: suspend () -> T): T

    abstract class Abstract(private val handleError: HandleError) : CloudDataSource {

        override suspend fun <T> handle(block: suspend () -> T): T = try {
            block.invoke()
        } catch (e: Exception) {
            throw handleError.handle(e)
        }
    }

}