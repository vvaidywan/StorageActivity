package com.example.storageactivity

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPrefUtil(context: Context) {

    private val pref = context.getSharedPreferences("StorageActivity", Context.MODE_PRIVATE)

    companion object{
        const val KEY_TEXT = "text"
    }

    fun getPreference(key : String, defaultValue : String) : String?{
        return pref.getString(key, defaultValue)
    }

    fun putPreference(key : String, value : String){
        val editor : SharedPreferences.Editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
        Log.d("", "====== key stored ${key}")
    }

}