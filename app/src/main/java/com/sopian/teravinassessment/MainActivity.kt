package com.sopian.teravinassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import com.sopian.teravinassessment.core.utils.NetworkMonitor
import com.sopian.teravinassessment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var useCase: MovieUseCase

    @Inject lateinit var networkMonitor: NetworkMonitor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            useCase.updateMovies()
        }
    }

    private fun netwokMonitor() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                networkMonitor.isOnline.collect { isConnected ->
                    if (!isConnected) {
                        Toast.makeText(this@MainActivity, "Not Connected", Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }
}