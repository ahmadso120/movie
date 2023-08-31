package com.sopian.teravinassessment.core.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject


class NotificationManager @Inject constructor(): NotificationHandler {
    private val _notification: MutableLiveData<String> = MutableLiveData()

    override fun notifyDataUpdate(message: String) {
        _notification.postValue(message)
    }

    override fun getNotification(): LiveData<String> {
        return _notification
    }
}