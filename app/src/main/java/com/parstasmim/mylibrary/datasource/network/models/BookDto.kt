package com.parstasmim.mylibrary.datasource.network.models

import com.google.gson.annotations.SerializedName

data class BookDto(
    @SerializedName("title") val title: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("genre") val genre: String?,
    @SerializedName("yearPublished") val yearPublished: Int?,
    @SerializedName("checkedOut") val checkedOut: Boolean?,
    @SerializedName("createdAt") val createdAt: String?
)