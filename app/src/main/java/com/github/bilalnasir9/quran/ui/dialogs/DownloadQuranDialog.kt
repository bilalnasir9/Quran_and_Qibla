package com.github.bilalnasir9.quran.ui.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.bilalnasir9.quran.R
import com.github.bilalnasir9.quran.base.BaseDialogFragment
import com.github.bilalnasir9.quran.base.visible
import com.github.bilalnasir9.quran.databinding.QuranDownloadingLyBinding
import com.github.bilalnasir9.quran.models.SplashViewModel


class DownloadQuranDialog(
    private val onDownloaded: () -> Unit,
    private val onCancel: (() -> Unit)? = null
) : BaseDialogFragment<QuranDownloadingLyBinding>() {

    private val viewModel: SplashViewModel by viewModels()

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        QuranDownloadingLyBinding.inflate(inflater, container, false)

    override fun setupUI() {
        binding.apply {

        }
        binding.btndownload.setOnClickListener {
            viewModel.startDownload(requireContext())
            binding.loadingLy.visible()
            binding.btndownload.text = getString(R.string.downloading)
            binding.btndownload.isEnabled = false
        }

        binding.btncross.setOnClickListener {
            onCancel?.invoke()
            dismiss()
        }

        viewModel.progress.observe(viewLifecycleOwner){
            binding.loadingTxt.text = buildString {
               append(it)
                append("%")
            }
        }
        viewModel.completed.observe(viewLifecycleOwner){
            if (it){
                dismiss()
               onDownloaded.invoke()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.let { window ->
            val margin = resources.getDimensionPixelSize(R.dimen.dialog_margin16)
            val screenWidth = Resources.getSystem().displayMetrics.widthPixels
            window.setLayout(screenWidth - (margin * 2), ViewGroup.LayoutParams.WRAP_CONTENT)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.setGravity(Gravity.CENTER)
            window.setDimAmount(0.8f)
        }
    }
}