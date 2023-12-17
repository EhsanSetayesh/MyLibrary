package com.parstasmim.mylibrary.presentation.modules.home

sealed class HomeEvent {
    object GetBooks : HomeEvent()
    object OnRemoveHeadFromQueue : HomeEvent()

}
