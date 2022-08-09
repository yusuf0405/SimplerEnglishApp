package com.joseph.core_mvvm.core

interface Mapper<From, To> {

    fun map(from: From): To

    interface Unit<From> : Mapper<From, kotlin.Unit>
}