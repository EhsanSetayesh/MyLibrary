package com.parstasmim.mylibrary.presentation.modules.home

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.parstasmim.mylibrary.databinding.ListItemBookBinding
import com.parstasmim.mylibrary.domain.models.BookBean
import com.parstasmim.mylibrary.presentation.base.BaseHolder
import com.parstasmim.mylibrary.utils.IRandomColorGenerator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class BooksListAdapter @Inject constructor(
    val randomColorGenerator: IRandomColorGenerator,
    private val onBookItemClicked: (BookBean) -> Unit,
) :
    ListAdapter<BookBean, BaseHolder<BookBean>>(object :
        DiffUtil.ItemCallback<BookBean>() {

        override fun areItemsTheSame(
            oldItem: BookBean,
            newItem: BookBean
        ): Boolean {
            return true
        }

        override fun areContentsTheSame(
            oldItem: BookBean,
            newItem: BookBean
        ): Boolean {
            return oldItem == newItem
        }

    }) {

    lateinit var context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseHolder<BookBean> {
        context = parent.context
        return BookViewHolder(
            ListItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseHolder<BookBean>, position: Int) {
        holder.bind(getItem(position)!!, position)
    }

    inner class BookViewHolder(
        private val binding: ListItemBookBinding
    ) : BaseHolder<BookBean>(binding) {

        override fun bind(value: BookBean, position: Int) {
            binding.apply {
                txtBookTitle.text = value.title
                txtBookAuthor.text = value.author
                txtBookGenre.text = value.genre
                txtBookCheckout.text = if(value.checkedOut == true) "Checked Out" else "Not Checked Out"
                txtBookYearOfPublished.text = value.yearPublished.toString()
                setRandomTintColor(imgBook)
            }
        }
        private fun setRandomTintColor(imageView: ImageView) {
            val randomColor = randomColorGenerator.getRandomColor()
            imageView.setColorFilter(randomColor, PorterDuff.Mode.SRC_ATOP)
        }
    }
}
