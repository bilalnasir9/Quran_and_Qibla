package com.github.bilalnasir9.quran.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.bilalnasir9.quran.base.BaseFragment
import com.github.bilalnasir9.quran.databinding.FragmentQiblaBinding
import com.github.bilalnasir9.quran.databinding.FragmentSplashBinding
import com.github.bilalnasir9.quran.models.SplashViewModel

class QiblaFragment : BaseFragment<FragmentQiblaBinding>() {
    private val viewModel: SplashViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentQiblaBinding {
        return FragmentQiblaBinding.inflate(inflater, container, false)
    }
}