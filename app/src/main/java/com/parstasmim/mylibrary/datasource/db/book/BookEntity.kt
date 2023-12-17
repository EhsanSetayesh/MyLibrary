package com.parstasmim.mylibrary.datasource.db.book

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.parstasmim.mylibrary.datasource.network.models.BookDto
import com.parstasmim.mylibrary.domain.models.BookBean

@Entity(tableName = "tbl_book")
data class BookEntity(
    var title: String? = null,
    var author: String? = null,
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var genre: String? = null,
    var yearPublished: Int? = null,
    var checkedOut: Boolean? = null
)

fun BookEntity.toDomain(): BookBean {
    return BookBean(
        title = title,
        author = author,
        id = id,
        genre = genre,
        yearPublished = yearPublished,
        checkedOut = checkedOut
    )
}