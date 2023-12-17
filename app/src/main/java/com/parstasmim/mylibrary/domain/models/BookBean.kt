package com.parstasmim.mylibrary.domain.models

data class BookBean(
    val title: String?,
    val author: String?,
    val id: String?,
    val genre: String?,
    val yearPublished: Int?,
    val checkedOut: Boolean?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BookBean

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}