package com.joseph.core_mvvm.core

interface Matches<T> {

    fun matches(data: T): Boolean

}