package com.manager.app.common.extenstions

import android.app.Activity
import androidx.fragment.app.Fragment
import java.io.IOException
import java.io.InputStream

fun Activity.readHtmlFromAssets(fileName: String): String {
    var str: String = ""
    try {

        val inputStream: InputStream = assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        str = String(buffer)
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return  str
}
fun Fragment.readHtmlFromAssets(fileName: String): String {
    var str: String = ""
    try {

        val inputStream: InputStream = requireActivity().assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        str = String(buffer)
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return  str
}

