package com.sopian.teravinassessment.core.framework

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import com.sopian.teravinassessment.core.utils.AlarmHandler
import com.sopian.teravinassessment.core.utils.NotificationHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieDataSyncService : Service() {

    @Inject
    lateinit var movieUseCase: MovieUseCase

    @Inject lateinit var alarmHandler: AlarmHandler

    @Inject lateinit var notificationHandler: NotificationHandler

    companion object {
        internal val TAG = MovieDataSyncService::class.java.simpleName
    }

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent == null) {
            return START_STICKY
        }
        Log.d(TAG, "Service running...")
        syncAndNotifyMoviesData()
        scheduleNextUpdate()
        return START_STICKY
    }

    private fun syncAndNotifyMoviesData(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                movieUseCase.updateMovies()
                notifyDataUpdate()
            } catch (e: Exception) {
                Log.e(TAG, e.localizedMessage.toString())
            }
        }
    }

    private fun scheduleNextUpdate() {
        val intent = Intent(this, MovieDataSyncService::class.java)
        val interval = 60000 // 1 minute
        alarmHandler.setAlarm(interval, intent, true)
    }

    private fun notifyDataUpdate() {
        notificationHandler.notifyDataUpdate("Data telah diperbarui!")
    }

}