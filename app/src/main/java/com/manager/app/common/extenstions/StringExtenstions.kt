package com.manager.app.common.extenstions

import android.content.ClipData
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Build
import android.widget.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import android.content.Context
import android.media.MediaMetadataRetriever
import android.net.Uri


fun String?.stringToReqBody(): RequestBody {
    return RequestBody.create("text/plain".toMediaTypeOrNull(), this!!);

}

fun String?.isEmptyString(): Boolean {
    return this?.trim().isNullOrBlank()
}

fun Context?.copyToClipBoard(msg: String) {
    val clipboard =
        this?.getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager?
    val clip = ClipData.newPlainText("text label", "${msg} #Caption it")
    clipboard!!.setPrimaryClip(clip)
    // Only show a toast for Android 12 and lower.
    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2)
        this?.showShortMessage("Text Copied")
}

fun String.getTotalDuration(): Long? {
    val mediaPath = Uri.parse(this).path
    val mmr = MediaMetadataRetriever()
    mmr.setDataSource(mediaPath)
    val duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
    mmr.release()
    return duration?.toLong()
}