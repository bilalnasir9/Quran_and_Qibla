package com.github.bilalnasir9.quran.ui.fragments

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import com.github.bilalnasir9.quran.R
import com.github.bilalnasir9.quran.adapters.QuranAdapter
import com.github.bilalnasir9.quran.base.BaseFragment
import com.github.bilalnasir9.quran.base.showToast
import com.github.bilalnasir9.quran.databinding.FragmentQuranBinding
import com.github.bilalnasir9.quran.models.QuranViewModel
import com.github.bilalnasir9.quran.utils.SharedPreferencesHelper

class ListQuranFragment : BaseFragment<FragmentQuranBinding>() {
    private val viewModel: QuranViewModel by viewModels()
    private var adapter: QuranAdapter? = null
    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentQuranBinding {
        return FragmentQuranBinding.inflate(inflater, container, false)
    }


    override fun setupViews() {
        viewModel.getParaList()
        adapter = QuranAdapter(ArrayList(), requireContext()) { item ->

            findNavController().navigate(
                ListQuranFragmentDirections.actionListquranToReadquran(
                    item.pageNumber
                )
            )
        }
        binding.quranListRv.adapter = adapter

        binding.apply {
            parahTitle.setOnClickListener {
                viewModel.getParaList()
                parahTitle.setTextColor(requireContext().getColor(R.color.white))
                surahTitle.setTextColor(requireContext().getColor(R.color.black))
                parahTitle.setBackgroundResource(R.drawable.gradientbtnshaperounded)
                surahTitle.setBackgroundResource(R.drawable.un_selected_rounded_btn)
            }
            surahTitle.setOnClickListener {
                viewModel.getSurahList()
                parahTitle.setTextColor(requireContext().getColor(R.color.black))
                surahTitle.setTextColor(requireContext().getColor(R.color.white))
                parahTitle.setBackgroundResource(R.drawable.un_selected_rounded_btn)
                surahTitle.setBackgroundResource(R.drawable.gradientbtnshaperounded)
            }
            btnlastread.setOnClickListener {
                val pageNo = SharedPreferencesHelper.getInt("LAST_PAGE_NO", -1)
                if (pageNo != -1) {
                    findNavController().navigate(
                        ListQuranFragmentDirections.actionListquranToReadquran(
                            pageNo.toString()
                        )
                    )
                } else {
                    requireContext().showToast(message = "No history yet, start reading first.")
                }
            }
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
            setupShowcase(btnlastread)
        }
    }

    private fun setupShowcase(view: View) {
        if (SharedPreferencesHelper.getBoolean("SHOW_CASE", false)) {
            return
        } else {
            TapTargetView.showFor(
                requireContext() as Activity,
                TapTarget.forView(view, getString(R.string.showcase_message))
                    .outerCircleColor(R.color.appcolor)
                    .targetCircleColor(android.R.color.white)
                    .textColor(android.R.color.white)
                    .titleTextSize(14)
                    .targetRadius(40)
                    .cancelable(true)
                    .outerCircleAlpha(1f)
                    .drawShadow(true)
            )
            SharedPreferencesHelper.putBoolean("SHOW_CASE", true)
        }
    }

    override fun observeViewModel() {
        viewModel.paralist.observe(viewLifecycleOwner) {
            adapter?.changeList(ArrayList(it))
        }
        viewModel.surahlist.observe(viewLifecycleOwner) {
            adapter?.changeList(ArrayList(it))
        }

    }
}