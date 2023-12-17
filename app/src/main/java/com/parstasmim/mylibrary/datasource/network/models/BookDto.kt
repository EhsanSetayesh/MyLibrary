package com.parstasmim.mylibrary.datasource.network.models

import com.google.gson.annotations.SerializedName
import com.parstasmim.mylibrary.datasource.db.book.BookEntity

data class BookDto(
    @SerializedName("title") val title: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("id") val id: String,
    @SerializedName("genre") val genre: String?,
    @SerializedName("yearPublished") val yearPublished: Int?,
    @SerializedName("checkedOut") val checkedOut: Boolean?,
    @SerializedName("createdAt") val createdAt: String?
)
fun BookDto.toDb(): BookEntity {
    return BookEntity(
        title = title,
        author = author,
        id = id,
        genre = genre,
        yearPublished = yearPublished,
        checkedOut = checkedOut,
    )
}