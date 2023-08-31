package com.sopian.teravinassessment.core.utils

import androidx.lifecycle.LiveData

interface NotificationHandler {
    fun notifyDataUpdate(message: String)
    fun getNotification(): LiveData<String>
}