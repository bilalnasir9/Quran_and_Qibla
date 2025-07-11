package com.github.bilalnasir9.quran.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment <VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract fun setupViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    open fun observeViewModel() {}
    open fun setupViews() {}

     fun navigateNext(resId: Int) {

        findNavController().navigate(resId)
    }

     fun navigateBack() {
        findNavController().popBackStack()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = setupViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeViewModel()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //call this extension function when you need to observe live data only once
    protected fun <T> LiveData<T>.observeOnce(observer: (T) -> Unit) {
        observe(viewLifecycleOwner) {
            observer(it)
            removeObservers(viewLifecycleOwner)
        }
    }

}