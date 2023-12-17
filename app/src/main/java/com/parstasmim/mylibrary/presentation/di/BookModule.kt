package com.parstasmim.mylibrary.presentation.di

import com.google.gson.Gson
import com.parstasmim.mylibrary.datasource.network.BookApiService
import com.parstasmim.mylibrary.domain.usecases.add_book.AddBookUseCase
import com.parstasmim.mylibrary.domain.usecases.get_book.GetBookUseCase
import com.parstasmim.mylibrary.domain.usecases.get_books.GetBooksUseCase
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
    fun provideGetBooksUseCase(
        bookApiService: BookApiService,
        gson: Gson
    ): GetBooksUseCase {
        return GetBooksUseCase(
            service = bookApiService,
            gson = gson
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
}