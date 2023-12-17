package com.parstasmim.mylibrary.presentation.modules.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parstasmim.mylibrary.domain.usecases.get_books.GetBooksUseCase
import com.parstasmim.mylibrary.utils.IRandomColorGenerator
import com.parstasmim.mylibrary.utils.state.StateMessage
import com.parstasmim.mylibrary.utils.state.UIComponentType
import com.parstasmim.mylibrary.utils.state.doesMessageAlreadyExistInQueue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val randomColorGenerator: IRandomColorGenerator,
    private val getBooksUseCase: GetBooksUseCase
) : ViewModel() {

    private val TAG: String = "HomeViewModel"

    val state: MutableLiveData<HomeState> =
        MutableLiveData(HomeState())

    fun onTriggerEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetBooks -> {
                getBooks()
            }

            is HomeEvent.OnRemoveHeadFromQueue -> {
                removeHeadFromQueue()
            }
        }
    }

    private fun getBooks() {
        resetState()

        state.value?.let { state ->
            getBooksUseCase.execute().onEach { dataState ->

                this.state.value = state.copy(isLoading = dataState.isLoading)

                dataState.data?.let { booksList ->
                    this.state.value = state.copy(booksList = booksList)
                }

                dataState.stateMessage?.let { stateMessage ->
                    appendToMessageQueue(stateMessage)
                }
            }.launchIn(viewModelScope)
        }
    }

    fun resetState() {
        state.value?.let { state ->
            this.state.value = state.copy(
                isLoading = false,
                booksList = null,
            )
        }
    }

    private fun appendToMessageQueue(stateMessage: StateMessage) {
        state.value?.let { state ->
            val queue = state.queue
            if (!stateMessage.doesMessageAlreadyExistInQueue(queue = queue)) {
                if (!(stateMessage.response.uiComponentType is UIComponentType.None)) {
                    queue.add(stateMessage)
                    this.state.value = state.copy(queue = queue)
                }
            }
        }
    }

    private fun removeHeadFromQueue() {
        state.value?.let { state ->
            try {
                val queue = state.queue
                queue.remove() // can throw exception if empty
                this.state.value = state.copy(queue = queue)
            } catch (e: Exception) {
                Log.d(TAG, "removeHeadFromQueue: Nothing to remove from DialogQueue")
            }
        }
    }

}
