package com.parstasmim.mylibrary.presentation.modules.home

import androidx.recyclerview.widget.DiffUtil
import com.parstasmim.mylibrary.domain.models.BookBean

class BookDiffCallback : DiffUtil.ItemCallback<BookBean>() {

    override fun areItemsTheSame(oldItem: BookBean, newItem: BookBean): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BookBean, newItem: BookBean): Boolean {
        return oldItem == newItem
    }
}
