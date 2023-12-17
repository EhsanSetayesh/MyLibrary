package com.parstasmim.mylibrary.domain.usecases.get_books

import com.google.gson.Gson
import com.parstasmim.mylibrary.datasource.db.book.BookDao
import com.parstasmim.mylibrary.datasource.network.BookApiService
import com.parstasmim.mylibrary.datasource.network.handleUseCaseException
import com.parstasmim.mylibrary.datasource.network.models.BookDto
import com.parstasmim.mylibrary.domain.models.BookBean
import com.parstasmim.mylibrary.utils.state.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetBooksUseCase(
    private val service: BookApiService, private val gson: Gson, private val bookDao: BookDao
) {
    fun execute(): Flow<DataState<List<BookBean>>> = flow {

        emit(DataState.loading())

        val serviceResponse = service.getBooks()
        if (serviceResponse.isSuccessful) {
            val bookListApi: List<BookDto>? = serviceResponse.body()

            val booksParserUseCase = bookListApi?.let { BooksParserUseCase(it, bookDao) }
            val booksListDomain = booksParserUseCase?.execute()

            emit(
                DataState.data(
                    data = booksListDomain
                )
            )
        } else {
            emit(handleUseCaseException(serviceResponse, gson))
        }
    }.catch { e ->
        emit(handleUseCaseException(e))
    }.flowOn(Dispatchers.IO)
}














