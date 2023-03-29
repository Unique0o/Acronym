package com.manager.app.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder

class ModelPreferences (c: Context, var namePreferences: String) {

    private var preferences:SharedPreferences
    private var editor:SharedPreferences.Editor
    private val gson = GsonBuilder().create()

    init {
        if (namePreferences.isEmpty()){
            namePreferences = "complex_preferences"
        }
        preferences = c.getSharedPreferences(namePreferences, Context.MODE_PRIVATE)
        editor= preferences.edit()
    }

    companion object{
        fun getModelPreferences(c: Context, namePreferences: String): ModelPreferences {
            return ModelPreferences(c, namePreferences)
        }

        fun getModelPreferences(c: Context): ModelPreferences {
            return ModelPreferences(c, "")
        }

    }


    fun <T> putObject(key: String, y: T) {
        val inString = gson.toJson(y)
        editor.putString(key, inString).commit()
    }


    fun <T> getObject(key: String, c: Class<T>): T? {
        val value = preferences.getString(key, null)
        if (value != null) {
            return gson.fromJson(value, c)
        } else {
            throw IllegalArgumentException("No object with key: $key was saved")
        }
    }


    fun commit() {
        editor.commit()
    }

    fun clearObject(key: String) {
        editor.remove(key)
    }
}
