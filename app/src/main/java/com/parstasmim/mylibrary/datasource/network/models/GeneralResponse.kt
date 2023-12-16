package com.parstasmim.mylibrary.datasource.network.models

data class GeneralResponse(
    val status: String,
    val message: String,
    val genre: String,
    val errors: List<ErrorBean>
)
