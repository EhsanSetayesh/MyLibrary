package com.parstasmim.mylibrary.presentation.callbacks

interface UICommunicationListener {

    fun showFullScreenLoading(isLoading: Boolean?)
    fun hideStatusBar()
    fun showStatusBar()
    fun hideToolbar()
    fun clearToolbar()

//    fun showToolbar(
//        showToolbarLogo: Boolean = true,
//        toolbarLogoIcon :Int = R.drawable.ic_app_logo_withoutname,
//        showBack: Boolean = true,
//        @ColorRes backIconTintColor: Int = R.color.white_100,
//        onBackButtonPressedCallBack: (() -> Unit)? = null,
//        toolbarTitle: String = "",
//        @ColorRes toolbarTitleTintColor: Int = R.color.white_100,
//        showMenu: Boolean = false,
//        menuIcon: Int = R.drawable.ic_menu,
//        @ColorRes menuIconTintColor: Int = R.color.white_100,
//        backgroundResId: Int? = R.drawable.shape_rec_bg_white_radius_bottom_20dp,
//        backgroundTintColor: Int? = null,
//        drawerLayoutLockModeEnabled: Boolean = false
//    )
}