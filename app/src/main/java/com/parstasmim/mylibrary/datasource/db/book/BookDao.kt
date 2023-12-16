package com.parstasmim.mylibrary.datasource.db.book

import androidx.room.*
import com.parstasmim.mylibrary.datasource.db.BaseDao

@Dao
interface BookDao : BaseDao<BookEntity> {
    @Query("SELECT * FROM tbl_book")
    suspend fun getBooks(): List<BookEntity>?
}
