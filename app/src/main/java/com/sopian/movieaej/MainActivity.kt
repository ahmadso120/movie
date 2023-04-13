package com.sopian.movieaej

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sopian.movieaej.ui.MovieApp
import com.sopian.movieaej.ui.theme.MovieAejTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                MovieApp()
            }
        }
    }
}