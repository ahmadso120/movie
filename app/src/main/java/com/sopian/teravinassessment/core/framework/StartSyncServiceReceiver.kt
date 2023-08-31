package com.sopian.teravinassessment.core.framework

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class StartSyncServiceReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val serviceIntent = Intent(context, MovieDataSyncService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(serviceIntent)
        }
        context.startService(serviceIntent)
    }
}