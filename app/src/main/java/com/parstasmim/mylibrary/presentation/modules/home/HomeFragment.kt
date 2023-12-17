package com.parstasmim.mylibrary.presentation.modules.home

import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.parstasmim.mylibrary.R
import com.parstasmim.mylibrary.databinding.FragmentHomeBinding
import com.parstasmim.mylibrary.domain.models.BookBean
import com.parstasmim.mylibrary.extensions.findNavControllerSafely
import com.parstasmim.mylibrary.extensions.processMessageQueue
import com.parstasmim.mylibrary.presentation.base.BaseFragment
import com.parstasmim.mylibrary.utils.RandomColorGenerator
import com.parstasmim.mylibrary.utils.state.StateMessageCallback
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val _viewModel: HomeViewModel by viewModels()

    private val booksListAdapter: BooksListAdapter by lazy {
        BooksListAdapter(_viewModel.randomColorGenerator) {

        }
    }

    override fun FragmentHomeBinding.initialize() {
        uiCommunicationListener.showStatusBar()
//        uiCommunicationListener.showToolbar(
//            toolbarTitle = resources.getString(R.string.page_title_samat),
//            onBackButtonPressedCallBack = { onBackButtonPressed() },
//        )

        setupViews()
        setupObserver()
        getBooks()

    }

    private fun setupViews() {
        binding.swipeRefresh.setOnRefreshListener {
            getBooks()
        }

        binding.rvBooks.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = booksListAdapter
        }
    }

    private fun setupObserver() {
        _viewModel.state.observe(viewLifecycleOwner) { state ->
            uiCommunicationListener.showFullScreenLoading(state.isLoading)

            checkForBookList(state.booksList)

            processMessageQueue(
                context = requireActivity(),
                queue = state.queue,
                stateMessageCallback = object : StateMessageCallback {
                    override fun removeMessageFromStack() {
                        _viewModel.onTriggerEvent(HomeEvent.OnRemoveHeadFromQueue)
                    }
                })
        }
    }

    private fun getBooks() {
        _viewModel.onTriggerEvent(HomeEvent.GetBooks)
        binding.swipeRefresh.isRefreshing = false
    }

    private fun checkForBookList(booksList: List<BookBean>?) {
        booksList?.let {
            if (it.isNotEmpty()) {
                booksListAdapter.submitList(it)
                binding.txtEmpty.visibility = View.GONE
            } else {
                binding.txtEmpty.visibility = View.VISIBLE
            }
        }
    }

    override fun onBackButtonPressed() {
        findNavControllerSafely()?.navigateUp()
    }

}

