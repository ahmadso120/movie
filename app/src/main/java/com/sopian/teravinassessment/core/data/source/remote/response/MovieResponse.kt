package com.sopian.teravinassessment.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sopian.teravinassessment.core.data.source.local.entity.MovieEntity

data class MovieResponse(
    val id: Int,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
)

fun MovieResponse.mapToEntity(): MovieEntity =
    MovieEntity(
        id = id,
        originalTitle = originalTitle,
        releaseDate = releaseDate
    )

fun List<MovieResponse>.mapToEntity(): List<MovieEntity> = map {
    it.mapToEntity()
}