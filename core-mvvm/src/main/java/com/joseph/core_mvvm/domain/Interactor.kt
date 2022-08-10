package com.joseph.core_mvvm.domain

import com.joseph.core_mvvm.core.Dispatchers
import com.joseph.core_mvvm.data.HandleError

interface Interactor {

    suspend fun <T> handle(
        successful: suspend (T) -> Unit,
        atFinish: suspend () -> Unit,
        block: suspend () -> T
    )

    abstract class Abstract(
        private val dispatchers: Dispatchers,
        private val handleError: HandleError
    ) : Interactor {

        override suspend fun <T> handle(
            successful: suspend (T) -> Unit,
            atFinish: suspend () -> Unit,
            block: suspend () -> T
        ) {
            try {
                val result = block.invoke()
                dispatchers.changeToUI { successful.invoke(result) }
            } catch (e: Exception) {
                handleError.handle(e)
            } finally {
                dispatchers.changeToUI { atFinish.invoke() }
            }
        }
    }
}