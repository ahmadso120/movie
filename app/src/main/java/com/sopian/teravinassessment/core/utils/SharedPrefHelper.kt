package com.sopian.teravinassessment.core.utils

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun setFirstRun(status: Boolean) {
        sharedPreferences.edit().putBoolean("isFirstRun", status).apply()
    }

    fun isFirstRun(): Boolean {
        return sharedPreferences.getBoolean("isFirstRun", false)
    }
}