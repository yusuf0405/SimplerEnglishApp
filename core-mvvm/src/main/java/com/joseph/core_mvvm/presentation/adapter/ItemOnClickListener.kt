package com.joseph.core_mvvm.presentation.adapter

import com.joseph.core_mvvm.presentation.ItemUi

interface ItemOnClickListener {

    fun showAnotherFragment(item: ItemUi) = Unit

    fun deleteItem(item: ItemUi, position: Int) = Unit

    fun updateItem(item: ItemUi, position: Int) = Unit
}