package com.sopian.movieaej

import android.app.Application
import com.sopian.movieaej.appinitializers.AppInitializers
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MovieAejApp : Application() {

    @Inject lateinit var initializers: AppInitializers
    override fun onCreate() {
        super.onCreate()

        initializers.init()
    }
}