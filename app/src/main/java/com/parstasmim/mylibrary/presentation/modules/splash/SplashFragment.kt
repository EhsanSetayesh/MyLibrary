package com.parstasmim.mylibrary.presentation.modules.splash

import com.parstasmim.mylibrary.R
import com.parstasmim.mylibrary.databinding.FragmentSplashBinding
import com.parstasmim.mylibrary.extensions.findNavControllerSafely
import com.parstasmim.mylibrary.extensions.main
import com.parstasmim.mylibrary.extensions.safeNavigate
import com.parstasmim.mylibrary.presentation.base.BaseFragment
import com.parstasmim.mylibrary.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private lateinit var splashJob: Job

    override fun FragmentSplashBinding.initialize() {
        uiCommunicationListener.hideStatusBar()
        uiCommunicationListener.hideToolbar()

        splashJob = main {
            delay(Constants.SPLASH_DELAY)
            findNavControllerSafely()?.safeNavigate(SplashFragmentDirections.actionSplashFragmentToNavHome())
        }
    }

    override fun onStop() {
        super.onStop()
        splashJob.cancelChildren()
    }

}

