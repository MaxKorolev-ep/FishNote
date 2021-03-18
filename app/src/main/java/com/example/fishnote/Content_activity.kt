package com.example.fishnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*

class Content_activity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        fishTitle.text = intent.getStringExtra("title")
        fishContent.text = intent.getStringExtra("content")
        fishIm.setImageResource(intent.getIntExtra("image",R.drawable.caras))

    }
}