package com.joseph.simplerapp.start_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.joseph.simplerapp.R
import com.joseph.simplerapp.databinding.FragmentFirstStartBinding

class FragmentFirstStart : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFirstStartBinding.inflate(layoutInflater)

        return binding.root
    }
}