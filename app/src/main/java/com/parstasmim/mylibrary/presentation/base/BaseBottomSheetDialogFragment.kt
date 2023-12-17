package com.parstasmim.mylibrary.presentation.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.parstasmim.mylibrary.presentation.callbacks.UICommunicationListener

abstract class BaseBottomSheetDialogFragment<T : ViewDataBinding> :
    BottomSheetDialogFragment() {


    lateinit var binding: T
    lateinit var uiCommunicationListener: UICommunicationListener
    abstract fun getResourceLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            uiCommunicationListener = context as UICommunicationListener
        }catch(e: ClassCastException){
            Log.e("TAG", "$context must implement UICommunicationListener" )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            getResourceLayoutId(),
            container,
            false
        )

        return binding.root
    }

    protected fun hideKeyboard(view: View) {
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    open fun showProgress(tag: String) {}
    open fun hideProgress(tag: String) {}
    open fun showError(tag: String, error: String, code: Int) {}
}