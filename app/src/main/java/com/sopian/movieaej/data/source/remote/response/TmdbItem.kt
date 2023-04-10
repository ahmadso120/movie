package com.sopian.movieaej.data.source.remote.response

import androidx.compose.runtime.Stable

@Stable
interface TmdbItem {
    val id: Int
    val title: String
    val posterPath: String?
    val adult: Boolean?
    val overview: String
    val releaseDate: String?
    val backdropPath: String?
    val voteAverage: Double
    val voteCount: Int
}