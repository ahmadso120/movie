package com.sopian.teravinassessment.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sopian.teravinassessment.core.domain.model.Movie

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo("original_title") val originalTitle: String?,
    @ColumnInfo("release_date") val releaseDate: String?,
)

fun MovieEntity.mapToDomainModel(): Movie =
    Movie(
        id = id,
        originalTitle = originalTitle,
        releaseDate = releaseDate
    )

fun List<MovieEntity>.mapToDomainModel(): List<Movie> = map {
    it.mapToDomainModel()
}