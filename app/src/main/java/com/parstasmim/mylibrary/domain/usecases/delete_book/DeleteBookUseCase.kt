package com.parstasmim.mylibrary.domain.usecases.delete_book

import com.google.gson.Gson
import com.parstasmim.mylibrary.datasource.network.BookApiService
import com.parstasmim.mylibrary.datasource.network.handleUseCaseException
import com.parstasmim.mylibrary.datasource.network.models.BookDto
import com.parstasmim.mylibrary.utils.state.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DeleteBookUseCase(
    private val service: BookApiService,
    private val gson: Gson,
) {
    fun execute(bookId: String): Flow<DataState<Boolean>> = flow {

        emit(DataState.loading())

        val serviceResponse = service.deleteBook(bookId)
        if (serviceResponse.isSuccessful) {
            emit(
                DataState.data(
                    data = true
                )
            )
        } else {
            emit(handleUseCaseException(serviceResponse, gson))
        }
    }.catch { e ->
        emit(handleUseCaseException(e))
    }.flowOn(Dispatchers.IO)
}














