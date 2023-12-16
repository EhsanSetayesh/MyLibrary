package com.parstasmim.mylibrary.utils.state


data class DataState<T>(
    val stateMessage: StateMessage? = null,
    val data: T? = null,
    val isLoading: Boolean = false
) {

    companion object {

        fun <T> error(
            response: MessageResponse,
        ): DataState<T> {
            return DataState(
                stateMessage = StateMessage(
                    response
                )
            )
        }

        fun <T> data(
            response: MessageResponse? = null,
            data: T? = null
        ): DataState<T> {
            return DataState(
                stateMessage = response?.let {
                    StateMessage(
                        it
                    )
                },
                data = data,
            )
        }

        fun <T> loading(): DataState<T> = DataState(isLoading = true)
    }
}