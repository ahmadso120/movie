package com.sopian.movieaej.data.source.remote.response

import com.sopian.movieaej.domain.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val id: Int,
    @Json(name = "poster_path") val posterPath: String?,
    val title: String
)

fun MovieResponse.asExternalModel() = Movie(
    id = id,
    title = title,
    posterUrl = "https://image.tmdb.org/t/p/original$posterPath"
)