package com.joseph.simplerapp.view_pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joseph.simplerapp.FragmentFirstStart
import com.joseph.simplerapp.FragmentSecondStart
import com.joseph.simplerapp.FragmentThirdStart
import com.joseph.simplerapp.databinding.FragmentViewPagerBinding

class FragmentViewPager : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        val adapter = ViewPagerAdapter(
            fragmentList = arrayListOf(
                FragmentFirstStart(),
                FragmentSecondStart(),
                FragmentThirdStart(),
            ),
            fm = childFragmentManager,
            lifecycle = lifecycle
        )
        binding.viewPager.adapter = adapter
        return binding.root
    }

}