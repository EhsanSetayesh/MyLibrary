package com.parstasmim.mylibrary.datasource.network.models

import com.google.gson.annotations.SerializedName

data class ErrorDto(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String
)
