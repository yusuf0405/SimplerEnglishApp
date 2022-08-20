package com.joseph.simplerapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentEnterNumber : Fragment() {

    companion object {
        fun newInstance() = FragmentEnterNumber()
    }

    private lateinit var viewModel: FragmentEnterNumberViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_number, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentEnterNumberViewModel::class.java)
        // TODO: Use the ViewModel
    }

}