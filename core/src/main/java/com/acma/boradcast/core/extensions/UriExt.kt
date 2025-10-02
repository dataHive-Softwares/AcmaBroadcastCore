package com.broad.acmabroad.core.extensions

import android.content.ContentResolver
import android.net.Uri
import android.webkit.MimeTypeMap

fun Uri.ext(contentResolver: ContentResolver): String {
    val mime: MimeTypeMap = MimeTypeMap.getSingleton()
    return mime.getExtensionFromMimeType(contentResolver.getType(this)) ?: ""
}