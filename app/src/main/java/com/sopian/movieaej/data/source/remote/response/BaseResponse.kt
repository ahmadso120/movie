package com.sopian.movieaej.data.source.remote.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: T?,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
)