package com.parstasmim.mylibrary.datasource.network.models

data class GeneralDto(
    val status: String,
    val message: String,
    val errors: List<ErrorDto>
)
