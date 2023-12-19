package com.parstasmim.mylibrary.presentation.modules.main

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.navigation.fragment.NavHostFragment
import com.hafizco.mobilebanksina.extensions.makeGone
import com.hafizco.mobilebanksina.extensions.makeNotClickable
import com.hafizco.mobilebanksina.extensions.makeNotEnable
import com.hafizco.mobilebanksina.extensions.makeVisible
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
        isLoading?.let {
            if (isLoading) {
                binding.incLoading.root.makeVisible()
                binding.incLoading.root.makeNotClickable()
                binding.incLoading.root.makeNotEnable()
                binding.incLoading.clLoadingContainer.makeNotClickable()
                binding.incLoading.clLoadingContainer.makeNotEnable()
                binding.incLoading.clLoadingContainer.setOnClickListener(null)
            } else {
                binding.incLoading.root.makeGone()
            }
        }
    }

    override fun hideToolbar() {
       // binding.toolbar.clToolbarContainer.makeInVisible()
    }

    override fun showToolbar(
        showBack: Boolean,
        onBackButtonPressedCallBack: (() -> Unit)?,
        toolbarTitle: String,
    ) {

        binding.toolbar.apply {

            txtToolbarTitle.text = toolbarTitle

            //handle back button
            if (showBack) {
                imgBack.makeVisible()
                imgBack.setOnClickListener { onBackButtonPressedCallBack?.invoke() }
            } else {
                imgBack.makeGone()
            }
        }
    }

    override fun clearToolbar() {
        binding.toolbar.apply {
            imgBack.makeGone()
            txtToolbarTitle.makeGone()
        }
    }

}