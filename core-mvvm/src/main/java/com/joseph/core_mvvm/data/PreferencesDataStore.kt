package com.joseph.core_mvvm.data

import android.content.SharedPreferences

interface PreferencesDataStore {

    fun save(key: String, data: String)

    fun read(key: String): String

    class Base(private val sharedPreferences: SharedPreferences) : PreferencesDataStore {

        override fun save(key: String, data: String) =
            sharedPreferences.edit().putString(key, data).apply()

        override fun read(key: String): String =
            sharedPreferences.getString(key, String()) ?: String()

    }
}