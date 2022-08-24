package com.joseph.simplerapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.joseph.simplerapp.databinding.FragmentEnterNumberBinding
import com.joseph.simplerapp.databinding.FragmentSignUpBinding

class FragmentEnterNumber : Fragment() {

    companion object {
        fun newInstance() = FragmentEnterNumber()
    }

    private lateinit var viewModel: FragmentEnterNumberViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEnterNumberBinding.inflate(layoutInflater)
        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentEnterNumber_to_fragmentVerificationCode)
        }
        return binding.root
    }


}