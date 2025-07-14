package com.github.bilalnasir9.quran.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.fragment.findNavController
import com.github.bilalnasir9.quran.base.BaseFragment
import com.github.bilalnasir9.quran.base.showToast
import com.github.bilalnasir9.quran.databinding.FragmentSplashBinding
import com.github.bilalnasir9.quran.ui.dialogs.DownloadQuranDialog
import com.github.bilalnasir9.quran.utils.FileUtils
import com.github.bilalnasir9.quran.utils.PermissionManager

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
//    private val viewModel: SplashViewModel by viewModels()
private lateinit var locationPermissionLauncher: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationPermissionLauncher = PermissionManager.registerLocationPermissionLauncher(this) { granted ->
            if (granted) {
                findNavController().navigate(SplashFragmentDirections.actionSplashToQibla())
            } else {
                requireContext().showToast(message = "Location permission is required to use this feature")
                findNavController().navigate(SplashFragmentDirections.actionSplashToQibla())
            }
        }
    }
    private fun checkAndRequestLocationPermission(isGranted:()->Unit) {
        if (PermissionManager.isLocationPermissionGranted(requireContext())) {
           isGranted.invoke()
        } else {
            locationPermissionLauncher.launch(PermissionManager.LOCATION_PERMISSION)
        }
    }
    override fun setupViews() {

        binding.apply {

            btncompass.setOnClickListener {
                checkAndRequestLocationPermission(isGranted = {
                    findNavController().navigate(SplashFragmentDirections.actionSplashToQibla())
                })
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