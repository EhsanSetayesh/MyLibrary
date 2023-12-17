package com.parstasmim.mylibrary.presentation.di

import com.google.gson.Gson
import com.parstasmim.mylibrary.datasource.db.AppDatabase
import com.parstasmim.mylibrary.datasource.db.book.BookDao
import com.parstasmim.mylibrary.datasource.network.BookApiService
import com.parstasmim.mylibrary.domain.usecases.add_book.AddBookUseCase
import com.parstasmim.mylibrary.domain.usecases.delete_book.DeleteBookUseCase
import com.parstasmim.mylibrary.domain.usecases.get_book.GetBookUseCase
import com.parstasmim.mylibrary.domain.usecases.get_books.GetBooksUseCase
import com.parstasmim.mylibrary.domain.usecases.update_book.UpdateBookUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BookModule {

    @Singleton
    @Provides
    fun provideBookDao(db: AppDatabase): BookDao {
        return db.getBookDao()
    }

    @Singleton
    @Provides
    fun provideGetBooksUseCase(
        bookApiService: BookApiService,
        gson: Gson,
        bookDao: BookDao
    ): GetBooksUseCase {
        return GetBooksUseCase(
            service = bookApiService,
            gson = gson,
            bookDao = bookDao
        )
    }

    @Singleton
    @Provides
    fun provideAddBookUseCase(
        bookApiService: BookApiService,
        gson: Gson
    ): AddBookUseCase {
        return AddBookUseCase(
            service = bookApiService,
            gson = gson
        )
    }

    @Singleton
    @Provides
    fun provideGetBookUseCase(
        bookApiService: BookApiService,
        gson: Gson
    ): GetBookUseCase {
        return GetBookUseCase(
            service = bookApiService,
            gson = gson
        )
    }

    @Singleton
    @Provides
    fun provideUpdateBookUseCase(
        bookApiService: BookApiService,
        gson: Gson
    ): UpdateBookUseCase {
        return UpdateBookUseCase(
            service = bookApiService,
            gson = gson
        )
    }

    @Singleton
    @Provides
    fun provideDeleteBookUseCase(
        bookApiService: BookApiService,
        gson: Gson
    ): DeleteBookUseCase {
        return DeleteBookUseCase(
            service = bookApiService,
            gson = gson
        )
    }
}