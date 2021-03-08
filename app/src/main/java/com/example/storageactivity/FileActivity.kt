package com.example.storageactivity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class FileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

        val f_et = findViewById<EditText>(R.id.f_et)
        val f_tv = findViewById<TextView>(R.id.f_tv)
        val btnRead = findViewById<Button>(R.id.btnRead)
        val btnWrite = findViewById<Button>(R.id.btnWrite)

        val file = "file.txt"

        btnWrite.setOnClickListener(View.OnClickListener {
            var text: String = f_et.text.toString()
            //val fileOutputStream : FileOutputStream
            try {
                val fOut: FileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fOut.write(text.toByteArray())
                fOut.close()
                Toast.makeText(baseContext, "file saved", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })

        btnRead.setOnClickListener(View.OnClickListener {
            try {
                val fIn: FileInputStream = openFileInput(file)
                var inputStreamReader = InputStreamReader(fIn)
                val bufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var buffer: String = bufferedReader.readLine()
//                while (buffer != null){
//                    stringBuilder.append(buffer)
//                    buffer = bufferedReader.readLine()
//                }
//
//                f_tv.text = stringBuilder.toString()

                val fin = openFileInput(file)
                var c: Int
                var temp = ""
                while (fin.read().also { c = it } != -1) {
                    temp = temp + Character.toString(c.toChar())
                }
                f_tv.text = temp
                fin.close()

            } catch (e: Exception) {
                //e.printStackTrace()
                Log.e("TAG error", "daaaaamnnnnn")
            }
        })

    }
}