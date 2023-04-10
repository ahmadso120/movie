package com.sopian.movieaej.data.source.remote.network

data class ApiError(
    val errorCode: Int,
    val statusCode: Int?,
    val statusMessage: String?
)