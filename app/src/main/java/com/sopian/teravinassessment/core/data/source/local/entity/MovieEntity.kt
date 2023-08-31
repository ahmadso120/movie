package com.sopian.teravinassessment.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    val id: Int,
    @ColumnInfo("original_title") val originalTitle: String?,
    @ColumnInfo("release_date") val releaseDate: String?,
)