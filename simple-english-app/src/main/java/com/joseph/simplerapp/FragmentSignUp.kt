package com.joseph.simplerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.joseph.simplerapp.databinding.FragmentSignUpBinding

class FragmentSignUp : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSignUpBinding.inflate(layoutInflater)
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentEnterNumber)
        }
        return binding.root
    }


}