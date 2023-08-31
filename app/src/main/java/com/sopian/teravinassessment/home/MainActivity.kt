package com.sopian.teravinassessment.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import com.sopian.teravinassessment.core.framework.StartSyncServiceReceiver
import com.sopian.teravinassessment.core.utils.AlarmHandler
import com.sopian.teravinassessment.core.utils.NetworkMonitor
import com.sopian.teravinassessment.core.utils.NotificationHandler
import com.sopian.teravinassessment.core.utils.SharedPrefHelper
import com.sopian.teravinassessment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var sharedPrefHelper: SharedPrefHelper

    @Inject lateinit var alarmHandler: AlarmHandler

    @Inject lateinit var notificationHandler: NotificationHandler

    @Inject lateinit var useCase: MovieUseCase

    @Inject lateinit var networkMonitor: NetworkMonitor

    private val viewModel: MainViewModel by viewModels()

    private val movieAdapter by lazy {
        MovieAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        netwokMonitor()

        observeData()

        setupAdapter()

        initiateSyncSchedule()
    }

    private fun initiateSyncSchedule() {
        val intent = Intent(this, StartSyncServiceReceiver::class.java)
        val interval = 60 * 1000 // 1 minute
        alarmHandler.setAlarm(interval, intent, false)
    }

    private fun observeData() {
        notificationHandler.getNotification().observe(this) {
            showNotification(it)
        }

        viewModel.movies.observe(this) {
            if (!it.isNullOrEmpty()) {
                movieAdapter.submitList(it)
            } else {
                if (!sharedPrefHelper.isFirstRun()) {
                    sharedPrefHelper.setFirstRun(true)
                    showNotification("Data kosong")
//                    initializeMovieData()
                }
            }
        }
    }

    private fun setupAdapter() {
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        binding.rvMovie.adapter = movieAdapter
    }

    private fun initializeMovieData(){
        lifecycleScope.launch {
            useCase.updateMovies()
            notificationHandler.notifyDataUpdate("Data telah diperbarui!")
        }
    }

    private fun netwokMonitor() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                networkMonitor.isOnline.collect { isConnected ->
                    if (!isConnected) {
                        showNotification("Not Connected", true)
                    }
                }

            }
        }
    }

    private fun showNotification(message: String, isLong: Boolean = false) {
        val duration = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        Toast.makeText(this, message, duration).show()
    }
}