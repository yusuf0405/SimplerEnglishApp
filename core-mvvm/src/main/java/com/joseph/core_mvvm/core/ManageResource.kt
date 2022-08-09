package com.joseph.core_mvvm.core

import android.content.Context
import androidx.annotation.StringRes

interface ManageResource {

    fun string(@StringRes id: Int): String

    class Base(private val context: Context) : ManageResource {

        override fun string(id: Int): String = context.getString(id)

    }
}