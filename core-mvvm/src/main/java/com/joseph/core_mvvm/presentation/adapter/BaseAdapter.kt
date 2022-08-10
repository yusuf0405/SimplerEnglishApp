package com.joseph.core_mvvm.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.joseph.core_mvvm.core.Mapper
import com.joseph.core_mvvm.presentation.DiffUtilCallback
import com.joseph.core_mvvm.presentation.ItemUi

class BaseAdapter(private val actionListener: ItemOnClickListener) :
    RecyclerView.Adapter<BaseViewHolder>(), Mapper<List<ItemUi>, Unit> {

    private var itemList = mutableListOf<ItemUi>()

    override fun map(from: List<ItemUi>) {
        val diffUtilCallback = DiffUtilCallback(itemList, from)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        itemList.clear()
        itemList.addAll(from)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int = itemList[position].type()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        TODO()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        holder.bind(itemList[position])

    override fun getItemCount(): Int = itemList.size

    fun addItem(newItem: ItemUi, position: Int) {
        itemList.add(position, newItem)
        notifyItemInserted(position)
    }

    fun deleteItem(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItem(position: Int, newItem: ItemUi) {
        itemList[position] = newItem
        notifyItemChanged(position)
    }

    fun checkForEmptiness(): Boolean = itemList.isEmpty()

}

