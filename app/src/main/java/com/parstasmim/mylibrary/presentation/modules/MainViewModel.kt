package com.parstasmim.mylibrary.presentation.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parstasmim.mylibrary.domain.usecases.get_books.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,

    ) : ViewModel() {

    private val TAG: String = "AppDebug"

    init {
        getBooks()
    }

    private fun getBooks() {

        getBooksUseCase.execute().onEach { dataState ->
            dataState.data?.let { booksList ->

            }

            dataState.stateMessage?.let { stateMessage ->
                stateMessage.response.message?.let {

                }
            }
        }.launchIn(viewModelScope)
    }
}
