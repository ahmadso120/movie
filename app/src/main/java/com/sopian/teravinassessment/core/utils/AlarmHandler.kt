package com.sopian.teravinassessment.core.utils

import android.content.Intent

interface AlarmHandler {
    fun setAlarm(interval: Int, intent: Intent, forService: Boolean)
}