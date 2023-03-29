package com.manager.app.data.preferences

import android.content.Context
import com.google.gson.Gson
import java.lang.Exception

class PreferenceProvider private constructor(context: Context) : BasePreference(context) {

    companion object {
        fun getInstance(ctx: Context): PreferenceProvider {
            return PreferenceProvider(ctx)
        }
    }

    private var value: String? = null

    private val IS_ALREADY_LOGIN = "isAlreadyLogin"
    private val IS_ONBOARDED = "isOnboarded"
    private val IS_TIPS_SHOWN = "isTipsShown"
    private val AUTH_VERIFICATION_ID = "authVerificationID"
    private val USER_ID = "userId"
    private val IMAGE_ID = "IMAGE_ID"
    private val PLAN_KEY = "plan_key"
    private val IS_PRO_PLAN_SUBSCRBED = "is_pro_plan_subscrbed"

    private val LONGITUDE = "Longitude"
    private val OTP_TOKEN = "otp_token"


    fun saveAlreadyLogin(saveAt: Boolean) {
        preference.edit().putBoolean(IS_ALREADY_LOGIN, saveAt).apply()
    }

    fun isAlreadyLogin(): Boolean {
        return preference.getBoolean(IS_ALREADY_LOGIN, false)
    }

    fun saveOnboarded(saveAt: Boolean) {
        preference.edit().putBoolean(IS_ONBOARDED, saveAt).apply()
    }

    fun isOnboarded(): Boolean {
        return preference.getBoolean(IS_ONBOARDED, false)
    }

    fun saveTipsShown(saveAt: Boolean) {
        preference.edit().putBoolean(IS_TIPS_SHOWN, saveAt).apply()
    }

    fun isTipsShown(): Boolean {
        return preference.getBoolean(IS_TIPS_SHOWN, false)
    }

    fun saveAuthVerificationID(saveAt: String) {
        preference.edit().putString(AUTH_VERIFICATION_ID, saveAt).apply()
    }

    fun getAuthVerificationID(): String? {
        return preference.getString(AUTH_VERIFICATION_ID, null)
    }

    fun saveUserId(saveAt: String) {
        preference.edit().putString(USER_ID, saveAt).apply()
    }

    fun getUserId(): String? {
        return preference.getString(USER_ID, null)
    }

    fun saveLongitude(saveAt: String) {
        preference.edit().putString(LONGITUDE, saveAt).apply()
    }

    fun getLongitude(): String? {
        return preference.getString(LONGITUDE, null)
    }


    fun isProPlanSubscribed(): Boolean {
        return preference.getBoolean(IS_PRO_PLAN_SUBSCRBED, false)
    }

    fun storeProPlanStatus(status: Boolean) {
        preference.edit().putBoolean(IS_PRO_PLAN_SUBSCRBED, status).apply()

    }


    //store object
    private fun storeObject(key: String?, obj: Any?) {
        val json = Gson().toJson(obj)
        preference.edit().putString(key, json).apply()
    }

    //get object
    private fun <T> getObject(key: String?, classOfT: Class<T>?): T? {
        val obj = getString(key, "")
        if (obj.equals("", ignoreCase = true)) return null
        val gson = Gson()
        return gson.fromJson(obj, classOfT)
    }

    fun getString(key: String?, `val`: String?): String? {
        try {
            value = preference!!.getString(key, `val`)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return value
    }

    fun clearAllPreferences() {
        val editor = preference.edit().clear()
        editor?.apply()
    }
    fun clearPreference() {
        saveAlreadyLogin(false)
        saveAuthVerificationID("")
        saveUserId("")

    }
}
