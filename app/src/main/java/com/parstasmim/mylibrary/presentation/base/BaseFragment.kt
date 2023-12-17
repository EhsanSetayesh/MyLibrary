package com.parstasmim.mylibrary.presentation.base


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.parstasmim.mylibrary.presentation.callbacks.UICommunicationListener

abstract class BaseFragment <T : ViewDataBinding>(@LayoutRes private val layoutResId : Int) : Fragment() {

    val TAG: String = "AppDebug"
    lateinit var uiCommunicationListener: UICommunicationListener

    private var _binding : T? = null
    val binding : T get() = _binding!!

    open fun onBackButtonPressed(){}
    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackButtonPressed()
        }
    }

    // Make it open, so it can be overridden in child fragments
    open fun T.initialize(){}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        // Optionally set lifecycle owner if needed
        binding.lifecycleOwner = viewLifecycleOwner

        // Calling the extension function
        binding.initialize()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            uiCommunicationListener = context as UICommunicationListener

        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement UICommunicationListener" )
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
        callback.isEnabled = true
    }

    override fun onPause() {
        super.onPause()
        callback.remove()
        callback.isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
