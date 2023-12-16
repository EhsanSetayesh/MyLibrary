package com.parstasmim.mylibrary.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.parstasmim.mylibrary.datasource.db.book.BookDao
import com.parstasmim.mylibrary.datasource.db.book.BookEntity
import com.parstasmim.mylibrary.utils.Constants

@Database(
    entities = [
        BookEntity::class], version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun getBookDao(): BookDao

    companion object {
        const val DATABASE_NAME: String = Constants.DB_NAME
    }
}








