package com.github.bilalnasir9.quran.base

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun String.show(): Boolean {
    return this.trim().equals("ON", ignoreCase = true)
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(
        this, message, length
    ).show()
}

fun View.showSnackbar(message: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, length).show()
}

fun Context.shareApp() {
    val i2 = Intent(Intent.ACTION_SEND)
    i2.type = "text/plain"
    i2.putExtra(
        Intent.EXTRA_TEXT,
        "Check out this app \n\n https://play.google.com/store/apps/details?id=${packageName} "
    )
    startActivity(i2)
}

fun Context.rateApp() {
    try {
        val intent =
            Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${packageName}"))
        startActivity(intent)
    } catch (e: Exception) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://play.google.com/store/apps/details?id=${packageName}")
        )
        startActivity(intent)
    }
}

fun Context.openPrivacyPolicy(url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.showMoreApps(url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

//fun Context.isInternetAvailable(): Boolean {
//    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    val network = connectivityManager.activeNetwork ?: return false
//    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
//    // ✅ Check if connected to a valid network (Wi-Fi or Mobile Data)
//    val hasInternet = capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
//            && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
//    return hasInternet
//}


fun Context.sendFeedbackEmail(to: String, subject: String = "", body: String = "") {
    try {
        val uri = Uri.parse(
            "mailto:${Uri.encode(to)}" +
                    "?subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(body)
        )

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = uri
        }
        try {
            startActivity(Intent.createChooser(intent, "Send Feedback"))
        } catch (e: Exception) {
            Log.e("sendFeedbackEmail", "Error sending email", e)
            Toast.makeText(this, "Error sending email", Toast.LENGTH_SHORT).show()
        }


//        val intent = Intent(Intent.ACTION_SENDTO).apply {
//            data = Uri.parse("mailto:$to")
//            putExtra(Intent.EXTRA_SUBJECT, subject)
//            putExtra(Intent.EXTRA_TEXT, body)
//        }
//        startActivity(Intent.createChooser(intent, "Send Feedback"))
    } catch (e: Exception) {
        Log.e("sendFeedbackEmail", "Error sending email", e)
        showToast("Error sending email")
    }
}

fun Context.startNewActivity(intent: Intent) {
    try {
        startActivity(intent)
    } catch (e: Exception) {
        Log.e("startNewActivity", "Error starting activity", e)
    }
}

fun Any.showlogD(tag: String = this::class.java.simpleName, message: String) {
    Log.d(tag, message)
}

fun Any.showlogE(message: String) {
    Log.e(this::class.java.simpleName, message)
}






