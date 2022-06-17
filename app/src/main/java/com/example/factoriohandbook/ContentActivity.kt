package com.example.factoriohandbook

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_2_layout.*
import kotlinx.android.synthetic.main.content_layout.*



class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_2_layout)

        //content_titleee.text = intent.getStringExtra("title")
        //contentDesc.text = intent.getStringExtra("content")
        //content_image.setImageResource(intent.getIntExtra("image",R.drawable.das))
        var index:Int = intent.getIntExtra("index",0)
        var cat:Int = intent.getIntExtra("cat",0)
        webView.loadUrl("file:///android_asset/${cat}_object_$index.html")
    }
}