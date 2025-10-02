package com.broad.acmabroad.core.extensions

import android.content.Context
import android.os.Build
import android.os.storage.StorageManager
import android.provider.Settings
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity

val Context.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this)

//fun Context.showToast(msg: String) {
//    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//}

fun Context.getStorageManager(): StorageManager {
    return getSystemService(AppCompatActivity.STORAGE_SERVICE) as StorageManager
}


fun Context.hasOverlayPermission(): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        Settings.canDrawOverlays(this)
    } else {
        // Overlay permissions were granted by default on older Android versions
        true
    }
}