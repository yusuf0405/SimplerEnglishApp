package com.joseph.simplerapp.start_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.joseph.simplerapp.R
import com.joseph.simplerapp.databinding.FragmentThirdStartBinding

class FragmentThirdStart : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentThirdStartBinding.inflate(layoutInflater)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentViewPager_to_fragmentLogin)
        }
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentViewPager_to_fragmentSignUp)
        }
        return binding.root
    }

}