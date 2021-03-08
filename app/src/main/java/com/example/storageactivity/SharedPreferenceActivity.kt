package com.example.storageactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        var sp_btn1 = findViewById<Button>(R.id.sp_btn1)
        var sp_btn2 = findViewById<Button>(R.id.sp_btn2)
        var sp_et = findViewById<EditText>(R.id.sp_et)
        var sp_tv = findViewById<TextView>(R.id.sp_tv)

        sp_btn1.setOnClickListener(View.OnClickListener {
            pref.putPreference(SharedPrefUtil.KEY_TEXT, sp_et.text.toString())
        })

        sp_btn2.setOnClickListener(View.OnClickListener {
            sp_tv.text = pref.getPreference(SharedPrefUtil.KEY_TEXT, "")
        })
    }
}