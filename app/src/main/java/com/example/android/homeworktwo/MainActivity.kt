package com.example.android.homeworktwo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.graphics.Bitmap


class MainActivity : AppCompatActivity() {

    private lateinit var name: String
    private lateinit var btnTakePhoto: Button
    private lateinit var editName: EditText
    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTakePhoto = findViewById(R.id.take_photo_button)
        editName = findViewById(R.id.name_edit)

        btnTakePhoto.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {

                name = editName.text.toString()

                if (name.isEmpty()) {
                    Toast.makeText(applicationContext, getString(R.string.error_string),
                            Toast.LENGTH_LONG).show()
                }
                else {
                    var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
                    }
                }
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === REQUEST_IMAGE_CAPTURE && resultCode === Activity.RESULT_OK) {
            val extras = data!!.extras
            val imageBitmap = extras.get("data") as Bitmap
            var intent = Intent(applicationContext, AfterTakePhotoActivity::class.java)

            intent.putExtra("image", imageBitmap)
            intent.putExtra(Intent.EXTRA_TEXT, name)

            startActivity(intent)
        }
    }
}
