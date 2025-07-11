package com.github.bilalnasir9.quran.models

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.github.bilalnasir9.quran.base.BaseViewModel
import com.github.bilalnasir9.quran.base.showlogD
import com.github.bilalnasir9.quran.utils.FileUtils
import com.github.bilalnasir9.quran.utils.FileUtils.getDownloadableUrl
import com.github.bilalnasir9.quran.utils.SharedPreferencesHelper

class SplashViewModel : BaseViewModel() {
//    fun startSplashTimer(callback: () -> Unit) {
//        launchOnMain {
//            delay(5000) // Simulate splash screen delay
//            callback.invoke()
//        }
//    }

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> = _progress

    private val _completed = MutableLiveData<Boolean>()
    val completed: LiveData<Boolean> = _completed

    fun startDownload(ctx: Context) {
        launchOnIO {
             PRDownloader.download(
                getDownloadableUrl(),
                FileUtils.getRootFilePath(ctx),
                FileUtils.getFileName()
            )
                .build()
                .setOnProgressListener { p ->
                    val percent = (p.currentBytes * 100 / p.totalBytes).toInt()
                    _progress.postValue(percent)
                    showlogD(message = "Download-Progress: $percent%")
                }
                .start(object : OnDownloadListener {
                    override fun onDownloadComplete() {
                        SharedPreferencesHelper.putString(
                            "PDF_FILE_PATH",
                            FileUtils.getPDFFile(ctx).absolutePath
                        )
                        _completed.postValue(true)
                    }

                    override fun onError(error: com.downloader.Error?) {
                        _completed.postValue(false)
                    }

                })
        }
    }
}