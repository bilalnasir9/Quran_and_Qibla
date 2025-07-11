package com.github.bilalnasir9.quran.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.bilalnasir9.quran.base.BaseFragment
import com.github.bilalnasir9.quran.base.showlogD
import com.github.bilalnasir9.quran.databinding.FragmentSplashBinding
import com.github.bilalnasir9.quran.models.SplashViewModel
import com.github.bilalnasir9.quran.ui.dialogs.DownloadQuranDialog
import com.github.bilalnasir9.quran.utils.FileUtils

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showlogD(message = "onViewCreated..")
    }
    override fun setupViews() {

        binding.apply {

            btncompass.setOnClickListener {
                findNavController().navigate(SplashFragmentDirections.actionSplashToQibla())
            }
            btnquran.setOnClickListener {
                btnQuranClick()
            }
        }

    }
    private fun btnQuranClick() {
        if (FileUtils.getPDFFile(requireContext()).exists()){
            findNavController().navigate(SplashFragmentDirections.actionSplashToQuran())
        }
        else{
            downloadQuran()
        }
    }
    private fun downloadQuran(){
       DownloadQuranDialog(onDownloaded = {
           findNavController().navigate(SplashFragmentDirections.actionSplashToQuran())
        },onCancel ={

        }
        ).show(childFragmentManager,"quranDownloadingDialog")
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }
}