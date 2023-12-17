package com.parstasmim.mylibrary.domain.models

data class BookBean(
    val title: String?,
    val author: String?,
    val id: String?,
    val genre: String?,
    val yearPublished: Int?,
    val checkedOut: Boolean?
)