package com.manager.app.data.preferences

import android.content.Context
import android.content.SharedPreferences

private const val  PREF_NAME = "CaptionIt"


open class BasePreference(context: Context) {

    private val appContext = context.applicationContext

    // Secure Share Preferences in android 6.0
//    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
//    private val preference : SharedPreferences
//        get() = EncryptedSharedPreferences.create(
//            PREF_NAME,
//            masterKeyAlias,
//            appContext,
//            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//        )

    public val preference : SharedPreferences
        get() = appContext.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

}
