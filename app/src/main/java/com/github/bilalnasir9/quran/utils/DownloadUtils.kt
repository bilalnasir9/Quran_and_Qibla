package com.github.bilalnasir9.quran.utils

import android.content.Context
import android.widget.Toast
import com.downloader.Error
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader

class DownloadUtils(val context: Context) {

    fun downloadingQuran(progressValue:(Int)->Unit,complete:()->Unit){
        val pdffilepath = "https://raw.githubusercontent.com/bilal-brightsquare/QuranFile/refs/heads/main/newquran.pdf"
         PRDownloader.download(pdffilepath, FileUtils.getRootFilePath(context), FileUtils.getFileName()).build().setOnProgressListener { p->
            val progress = p.currentBytes * 100 / p.totalBytes
            progressValue.invoke(progress.toInt())
        }.start(object :OnDownloadListener{
            override fun onDownloadComplete() {
                SharedPreferencesHelper.putString("PDF_FILE_PATH",FileUtils.getPDFFile(context).absolutePath)
                complete.invoke()
            }

            override fun onError(error: Error?) {
                Toast.makeText(context, "Unable to download", Toast.LENGTH_SHORT).show()
            }

        })


    }
}