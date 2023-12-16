package com.parstasmim.mylibrary.datasource.network

import com.parstasmim.mylibrary.datasource.network.models.BookBean
import com.parstasmim.mylibrary.datasource.network.models.GeneralResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface BookApiService {
    @GET
    suspend fun getBooks(): Response<List<BookBean>>

    @GET("/{id}")
    suspend fun getBook(
        @Path("id") bookId: String,
    ): Response<BookBean>

    @POST
    suspend fun addBook(
        @Body body: BookBean
    ): Response<GeneralResponse>

    @PATCH("/{id}")
    suspend fun updateBook(
        @Path("id") bookId: String,
        @Body body: BookBean
    ): Response<GeneralResponse>

    @DELETE("/{id}")
    suspend fun deleteBook(
        @Path("id") bookId: String,
    ): Response<GeneralResponse>
}





