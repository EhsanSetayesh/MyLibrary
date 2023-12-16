package com.parstasmim.mylibrary.datasource.db.book

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.parstasmim.mylibrary.datasource.network.models.BookDto

@Entity(tableName = "tbl_book")
data class BookEntity(
    var title: String? = null,
    var author: String? = null,
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var genre: String? = null,
    var yearPublished: Int? = null,
    var checkedOut: Boolean? = null,
    var createdAt: String? = null,
    ) {

}

fun BookEntity.toBookDto(): BookDto {
    return BookDto(
        title = title,
        author = author,
        id = id,
        genre = genre,
        yearPublished = yearPublished,
        checkedOut = checkedOut,
        createdAt = createdAt,
    )
}