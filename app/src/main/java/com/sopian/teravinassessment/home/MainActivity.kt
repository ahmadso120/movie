package com.sopian.teravinassessment.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import com.sopian.teravinassessment.core.utils.NetworkMonitor
import com.sopian.teravinassessment.core.utils.SharedPrefHelper
import com.sopian.teravinassessment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var sharedPrefHelper: SharedPrefHelper

    @Inject
    lateinit var useCase: MovieUseCase

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
    }

    private fun observeData() {
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