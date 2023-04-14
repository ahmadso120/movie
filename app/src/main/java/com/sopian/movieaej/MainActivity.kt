package com.sopian.movieaej

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sopian.movieaej.data.util.NetworkMonitor
import com.sopian.movieaej.ui.MovieApp
import com.sopian.movieaej.ui.theme.MovieAejTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = rememberSystemUiController()

            MovieAejTheme {
                val navBarColor = MaterialTheme.colorScheme.surface
                val statusBarColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
                val darkTheme = isSystemInDarkTheme()

                SideEffect {
                    if (darkTheme) {
                        systemUiController.setStatusBarColor(
                            color = statusBarColor,
                            darkIcons = false
                        )
                    } else {
                        systemUiController.setStatusBarColor(
                            color = statusBarColor,
                            darkIcons = true
                        )
                    }
                    systemUiController.setNavigationBarColor(
                        color = navBarColor,
                        darkIcons = true
                    )
                }
                MovieApp(networkMonitor = networkMonitor)
            }
        }
    }
}