package com.example.storageactivity

import android.app.Application

val pref:SharedPrefUtil by lazy {
    MyApplication.sharedPreferences!!
}
class MyApplication : Application() {

    companion object {
        var sharedPreferences: SharedPrefUtil? = null
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = SharedPrefUtil(this)

    }
}