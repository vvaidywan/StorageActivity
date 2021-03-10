package com.example.storageactivity

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_content_provider.*
import java.io.File

private val RQS_OPEN_DOCUMENT_TREE = 1000
class ContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        cp_btnPerm.setOnClickListener {
            val value = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )

            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
            startActivityForResult(intent, RQS_OPEN_DOCUMENT_TREE)

            val path: String = Environment.getExternalStorageDirectory().getAbsolutePath()
            val f = File(path) //converted string object to file

            val values: Array<String> = f.list() //getting the list of files in string array

        }
    }
}