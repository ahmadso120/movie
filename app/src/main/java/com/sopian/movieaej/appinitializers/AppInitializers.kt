package com.sopian.movieaej.appinitializers

import com.sopian.movieaej.common.appinitializers.AppInitializer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
){
    fun init() {
        initializers.forEach { initializer ->
            initializer.init()
        }
    }
}