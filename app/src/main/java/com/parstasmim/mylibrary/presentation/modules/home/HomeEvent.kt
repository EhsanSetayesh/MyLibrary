package com.parstasmim.mylibrary.presentation.modules.home

sealed class HomeEvent {
    object GetBooks : HomeEvent()
    data class DeleteBook(val bookId: String) : HomeEvent()
    object OnRemoveHeadFromQueue : HomeEvent()

}
