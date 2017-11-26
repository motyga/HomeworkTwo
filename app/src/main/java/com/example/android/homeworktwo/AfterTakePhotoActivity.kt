package com.example.android.homeworktwo

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AfterTakePhotoActivity : AppCompatActivity() {

    private lateinit var textview:  TextView
    private lateinit var imageview: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_take_photo)

        textview = findViewById(R.id.textview_id)
        imageview = findViewById(R.id.imageview_id)

        textview.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        imageview.setImageBitmap(intent.extras.get("image") as Bitmap)
    }
}
