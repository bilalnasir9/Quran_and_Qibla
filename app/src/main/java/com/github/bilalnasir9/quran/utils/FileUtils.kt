package com.github.bilalnasir9.quran.utils

import android.content.Context
import java.io.File

object FileUtils {
    private val url = "https://raw.githubusercontent.com/bilal-brightsquare/QuranFile/refs/heads/main/newquran.pdf"

    private var fileName = "AlQuran.pdf"

    fun getDownloadableUrl(): String {
        return url
    }
    fun getFileName(): String {
        return fileName
    }
    fun getRootFilePath(context: Context): String {
        return context.filesDir.absolutePath
    }
    fun getPDFFile(context: Context): File {
        return File(getRootFilePath(context), getFileName())
    }
}