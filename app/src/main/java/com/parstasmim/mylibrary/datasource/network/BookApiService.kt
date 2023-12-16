package com.parstasmim.mylibrary.datasource.network

import com.parstasmim.mylibrary.datasource.network.models.BookDto
import com.parstasmim.mylibrary.datasource.network.models.GeneralDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface BookApiService {
    @GET("book/")
    suspend fun getBooks(): Response<List<BookDto>>

    @GET("books/{id}")
    suspend fun getBook(
        @Path("id") bookId: String,
    ): Response<BookDto>

    @POST("books/")
    suspend fun addBook(
        @Body body: BookDto
    ): Response<GeneralDto>

    @PATCH("books/{id}")
    suspend fun updateBook(
        @Path("id") bookId: String,
        @Body body: BookDto
    ): Response<GeneralDto>

    @DELETE("books/{id}")
    suspend fun deleteBook(
        @Path("id") bookId: String,
    ): Response<GeneralDto>
}





