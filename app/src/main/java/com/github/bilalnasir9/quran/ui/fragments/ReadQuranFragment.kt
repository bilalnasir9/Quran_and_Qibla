package com.github.bilalnasir9.quran.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.github.bilalnasir9.quran.base.BaseFragment
import com.github.bilalnasir9.quran.base.showlogD
import com.github.bilalnasir9.quran.databinding.FragmentReadquranBinding
import com.github.bilalnasir9.quran.utils.FileUtils
import com.github.bilalnasir9.quran.utils.SharedPreferencesHelper
import java.io.File

class ReadQuranFragment : BaseFragment<FragmentReadquranBinding>() {
    val pageNumbers = IntArray(611) { it + 0 }
    private var lastPage = -1

    override fun setupViews() {

        val numb = ReadQuranFragmentArgs.fromBundle(requireArguments()).pagNo

        val pageNum = numb.replace("[()]".toRegex(), "").toInt()

        loadPdf(pageNum.minus(1))
        binding.apply {

        }

    }

    fun loadPdf(numb: Int) {
        binding.pdfView.fromFile(File(FileUtils.getPDFFile(requireContext()).absolutePath))
            .pages(*pageNumbers) // all pages are displayed by default
            .swipeHorizontal(true)
            .enableSwipe(true)
            .pageFling(true)
            .defaultPage(numb)
            .pageSnap(true)
            .spacing(0)
            .onPageChange { page, _ ->
                showlogD(message = "onPageChanged: $page")
                lastPage = page
            }
            .pageFitPolicy(FitPolicy.BOTH)
            .load()
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentReadquranBinding {
        return FragmentReadquranBinding.inflate(inflater, container, false)
    }

    override fun onDestroyView() {
        showlogD(message = "history saved")
        SharedPreferencesHelper.putInt("LAST_PAGE_NO", lastPage.plus(1))
        super.onDestroyView()
    }

    override fun onPause() {
        showlogD(message = "app paused")
        SharedPreferencesHelper.putInt("LAST_PAGE_NO", lastPage.plus(1))
        super.onPause()
    }
}