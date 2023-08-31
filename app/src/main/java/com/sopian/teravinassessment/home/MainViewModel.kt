package com.sopian.teravinassessment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    useCase: MovieUseCase
) : ViewModel() {
    val movies = useCase.getMovies().asLiveData()
}