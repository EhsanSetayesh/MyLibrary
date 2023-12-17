package com.parstasmim.mylibrary.presentation.base

sealed class BaseEvent {
    object GetScreenTimeOut : BaseEvent()
    object OnRemoveHeadFromQueue : BaseEvent()
}
