package com.github.bilalnasir9.quran.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.bilalnasir9.quran.base.BaseViewModel
import com.github.bilalnasir9.quran.base.showlogD
import com.github.bilalnasir9.quran.utils.QuranDataUtils

class QuranViewModel : BaseViewModel() {

   private val _paralist=MutableLiveData<List<QuranModel>>()
    val paralist:LiveData<List<QuranModel>> = _paralist

    private val _surahlist=MutableLiveData<List<QuranModel>>()
    val surahlist:LiveData<List<QuranModel>> = _surahlist

    private var tempParalist=ArrayList<QuranModel>()
    private var tempSurahlist=ArrayList<QuranModel>()


    fun getParaList(){
        if (tempParalist.isNotEmpty()){
            showlogD(message = "list is not empty")
            _paralist.postValue(tempParalist)
            return
        }
        tempParalist=QuranDataUtils.allParas()
        _paralist.postValue(tempParalist)
    }
    fun getSurahList(){
        if (tempSurahlist.isNotEmpty()){
            showlogD(message = "list is not empty")
            _surahlist.postValue(tempSurahlist)
            return
        }
        tempSurahlist=QuranDataUtils.allSurah()
        _surahlist.postValue(tempSurahlist)
    }
}