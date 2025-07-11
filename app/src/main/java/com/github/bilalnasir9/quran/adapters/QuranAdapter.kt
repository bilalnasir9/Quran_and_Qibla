package com.github.bilalnasir9.quran.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.bilalnasir9.quran.databinding.ViewAdapterLyBinding
import com.github.bilalnasir9.quran.models.QuranModel

class QuranAdapter(private var list: ArrayList<QuranModel>, val mContext: Context, private val itemCLick:(QuranModel)->Unit) :
    RecyclerView.Adapter<QuranAdapter.QuranViewHolder>() {


    private var listNum = 0

    inner class QuranViewHolder(val binding: ViewAdapterLyBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val binding = ViewAdapterLyBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return QuranViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        ++listNum
        val num = position + 1
        holder.binding.num.text = num.toString()
        holder.binding.englishName.text = list[position].englishName
        val pageNum = list[position].pageNumber.replace("[()]".toRegex(), "")
        holder.binding.arabicTxt.text = list[position].arabicName

        holder.binding.root.setOnClickListener {
            try {
                Log.d("PAGENUM", "selected page: $pageNum")
                itemCLick.invoke(list[position])
//                mContext.startActivity(Intent(mContext, ViewQuranActivity::class.java).apply {
//                    putExtra(AppCons.PAGE_NUM, pageNum.toInt())
//                })
            } catch (e: Exception) {

            }
        }
    }

    fun changeList(list: ArrayList<QuranModel>) {
        listNum = 0
        this.list = list
        notifyDataSetChanged()
    }
}