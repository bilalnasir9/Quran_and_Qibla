package com.github.bilalnasir9.quran.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

object PermissionManager {
    const val LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION
    fun isLocationPermissionGranted(ctx: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            ctx,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun registerLocationPermissionLauncher(
        fragment: Fragment,
        onResult: (granted: Boolean) -> Unit
    ): ActivityResultLauncher<String> {
        return fragment.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            onResult(isGranted)
        }
    }
}