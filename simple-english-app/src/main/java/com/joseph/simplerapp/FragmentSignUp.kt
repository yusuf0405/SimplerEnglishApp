package com.joseph.simplerapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.joseph.simplerapp.databinding.FragmentSignUpBinding
import com.joseph.simplerapp.databinding.FragmentThirdStartBinding

class FragmentSignUp : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSignUpBinding.inflate(layoutInflater)
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentVerificationCode)
        }
        return binding.root
    }


}