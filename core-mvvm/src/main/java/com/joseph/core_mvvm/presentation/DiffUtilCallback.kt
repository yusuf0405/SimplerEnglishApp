package com.joseph.core_mvvm.presentation

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback(
    private val oldList: List<ItemUi>,
    private val newList: List<ItemUi>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id() == newList[newItemPosition].id()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}