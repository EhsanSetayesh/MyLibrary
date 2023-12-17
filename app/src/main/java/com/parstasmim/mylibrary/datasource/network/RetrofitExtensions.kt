package com.parstasmim.mylibrary.datasource.network

import com.google.gson.Gson
import com.parstasmim.mylibrary.datasource.network.models.ErrorDto
import com.parstasmim.mylibrary.utils.message.ErrorHandling
import com.parstasmim.mylibrary.utils.state.DataState
import com.parstasmim.mylibrary.utils.state.MessageResponse
import com.parstasmim.mylibrary.utils.state.MessageType
import com.parstasmim.mylibrary.utils.state.UIComponentType
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

fun <T> handleUseCaseException(e: Throwable): DataState<T> {
    e.printStackTrace()
    val message: String? = when (e) {
        is IOException -> {
            ErrorHandling.ERROR_CHECK_NETWORK_CONNECTION
        }
        is HttpException -> {
            convertErrorBody(e)
        }
        else -> {
            ErrorHandling.ERROR_SERVER_RESPONSE_IS_UNKNOWN
        }
    }
    return DataState.error(
        response = MessageResponse(
            message = message,
            uiComponentType = UIComponentType.Toast(),
            messageType = MessageType.Error()
        )
    )
}

fun <T, V> handleUseCaseException(response: Response<T>?, gson: Gson): DataState<V> {
    val errorMessage = response?.errorBody()?.let {
        gson.fromJson(it.charStream(), ErrorDto::class.java)
    }?.message ?: ErrorHandling.ERROR_SERVER_RESPONSE_IS_UNKNOWN

    return DataState.error(
        response = MessageResponse(
            message = errorMessage,
            uiComponentType = UIComponentType.Toast(),
            messageType = MessageType.Error()
        )
    )
}

private fun convertErrorBody(throwable: HttpException): String? {
    return try {
        throwable.response()?.errorBody()?.string()
    } catch (exception: Exception) {
        ErrorHandling.ERROR_SERVER_RESPONSE_IS_UNKNOWN
    }
}