package com.parstasmim.mylibrary.presentation.modules.home

import com.parstasmim.mylibrary.domain.models.BookBean
import com.parstasmim.mylibrary.utils.state.Queue
import com.parstasmim.mylibrary.utils.state.StateMessage

data class HomeState(
    val isLoading: Boolean? = null,
    val booksList: List<BookBean>? = null,
    val queue: Queue<StateMessage> = Queue(mutableListOf()),
    )