package com.joseph.core_mvvm.data

interface HandleError {

    fun handle(error: Exception): Exception
}