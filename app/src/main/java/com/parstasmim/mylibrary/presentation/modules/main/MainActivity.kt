package com.parstasmim.mylibrary.presentation.modules.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.parstasmim.mylibrary.R
import com.parstasmim.mylibrary.databinding.ActivityMainBinding
import com.parstasmim.mylibrary.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navHostFragment by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
    }
    private val navController by lazy {
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun showFullScreenLoading(isLoading: Boolean?) {
//        isLoading?.let {
//            if (isLoading) {
//                binding.incLoading.root.makeVisible()
//                binding.incLoading.root.makeNotClickable()
//                binding.incLoading.root.makeNotEnable()
//                binding.incLoading.clLoadingContainer.makeNotClickable()
//                binding.incLoading.clLoadingContainer.makeNotEnable()
//                binding.incLoading.clLoadingContainer.setOnClickListener(null)
//            } else {
//                binding.incLoading.root.makeGone()
//            }
//        }
    }

    override fun hideToolbar() {
       // binding.toolbar.clToolbarContainer.makeInVisible()
    }

//    override fun showToolbar(
//        showToolbarLogo: Boolean,
//        toolbarLogoIcon: Int,
//        showBack: Boolean,
//        backIconTintColor: Int,
//        onBackButtonPressedCallBack: (() -> Unit)?,
//        toolbarTitle: String,
//        toolbarTitleTintColor: Int,
//        showMenu: Boolean,
//        menuIcon: Int,
//        menuIconTintColor: Int,
//        backgroundResId: Int?,
//        backgroundTintColor: Int?,
//        drawerLayoutLockModeEnabled: Boolean
//    ) {
//
//        if(drawerLayoutLockModeEnabled) {
//            binding.drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
//        }else {
//            binding.drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED)
//        }
//
//        binding.toolbar.apply {
//            clToolbarContainer.makeVisible()
//            if (backgroundResId != null) {
//                if (backgroundTintColor == null) {
//                    clToolbarContainer.setBackgroundResource(backgroundResId)
//                    clToolbarContainer.setBackgroundTintColor(
//                        applicationContext,
//                        getBackgroundFromAttribute(R.attr.toolbarBackgroundColor)
//                    )
//                } else {
//                    clToolbarContainer.setBackgroundResource(backgroundResId)
//                    clToolbarContainer.setBackgroundTintColor(
//                        this@MainActivity,
//                        backgroundTintColor
//                    )
//                }
//
//            } else {
//                clToolbarContainer.background = null
//            }
//
//            if (showToolbarLogo) {
//                imgToolbarLogo.makeVisible()
//                imgToolbarLogo.setImageResource(toolbarLogoIcon)
//            } else {
//                imgToolbarLogo.makeGone()
//            }
//
//            //handle back button
//            if (showBack) {
//                imgBack.makeVisible()
//                ImageViewCompat.setImageTintList(
//                    imgBack,
//                    ColorStateList.valueOf(
//                        ContextCompat.getColor(
//                            this@MainActivity,
//                            backIconTintColor
//                        )
//                    )
//                )
//                imgBack.setColorFilter(
//                    ContextCompat.getColor(this@MainActivity, backIconTintColor),
//                    android.graphics.PorterDuff.Mode.SRC_IN
//                )
//                imgBack.setOnClickListener { onBackButtonPressedCallBack?.invoke() }
//            } else {
//                imgBack.makeGone()
//            }
//            //handle menu button
//            if (showMenu) {
//
//                imgMenu.apply {
//                    makeVisible()
//                    ImageViewCompat.setImageTintList(
//                        this,
//                        ColorStateList.valueOf(
//                            ContextCompat.getColor(
//                                this@MainActivity,
//                                menuIconTintColor
//                            )
//                        )
//                    )
//                    setColorFilter(
//                        ContextCompat.getColor(this@MainActivity, menuIconTintColor),
//                        android.graphics.PorterDuff.Mode.SRC_IN
//                    )
//                    setImageResource(menuIcon)
//                    setOnClickListener {
//                        if (binding.drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
//                            binding.drawerLayout.closeDrawer(Gravity.RIGHT)
//                        } else {
//                            binding.drawerLayout.openDrawer(Gravity.RIGHT)
//                        }
//                    }
//                }
//            } else {
//                imgMenu.makeGone()
//            }
//
//
//            txtToolbarTitle.text = toolbarTitle
//            txtToolbarTitle.setTextColor(
//                ContextCompat.getColor(
//                    this@MainActivity,
//                    toolbarTitleTintColor
//                )
//            )
//
//
//        }
//    }

    override fun clearToolbar() {
//        binding.toolbar.apply {
//            imgMenu.makeGone()
//            imgBack.makeGone()
//            txtToolbarTitle.makeGone()
//            imgToolbarLogo.makeGone()
//        }
    }

}