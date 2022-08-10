package com.joseph.core_mvvm.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.joseph.core_mvvm.presentation.ItemUi

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: ItemUi)
}