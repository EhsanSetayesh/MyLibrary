package com.parstasmim.mylibrary.presentation.callbacks

interface UICommunicationListener {

    fun showFullScreenLoading(isLoading: Boolean?)
    fun hideStatusBar()
    fun showStatusBar()
    fun hideToolbar()
    fun clearToolbar()

    fun showToolbar(
        showBack: Boolean = true,
        onBackButtonPressedCallBack: (() -> Unit)? = null,
        toolbarTitle: String = "",
    )
}