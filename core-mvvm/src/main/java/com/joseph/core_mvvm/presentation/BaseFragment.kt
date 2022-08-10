package com.joseph.core_mvvm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<V : ViewBinding, VM : ViewModel>(
    private val binder: (LayoutInflater, ViewGroup?, Boolean) -> V,
) : Fragment() {

    protected abstract val viewModel: VM

    private var viewBinding: V? = null

    protected fun binding(): V = checkNotNull(viewBinding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = binder.invoke(inflater, container, false)
        viewBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun showToast(@StringRes messageRes: Int) {
        Toast.makeText(requireContext(), messageRes, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}