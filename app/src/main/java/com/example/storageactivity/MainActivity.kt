package com.example.storageactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var btn3 = findViewById<Button>(R.id.btn3)
        var btn4 = findViewById<Button>(R.id.btn4)

        btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, SharedPreferenceActivity::class.java)
            startActivity(intent)
        })

        btn2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, FileActivity::class.java)
            startActivity(intent)
        })

        btn3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, RoomActivity::class.java)
            startActivity(intent)
        })

        btn4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ContentProviderActivity::class.java)
            startActivity(intent)
        })
    }
}