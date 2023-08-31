package com.sopian.teravinassessment.core.domain.model

data class Movie(
    val id: Int,
    val originalTitle: String? = "",
    val releaseDate: String? = "",
)