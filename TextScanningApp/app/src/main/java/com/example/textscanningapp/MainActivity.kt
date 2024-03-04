package com.example.textscanningapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class MainActivity : AppCompatActivity() {
    lateinit var result:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val camera = findViewById<ImageView>(R.id.btnCamera)
        val erase = findViewById<ImageView>(R.id.btnErase)
        val copy = findViewById<ImageView>(R.id.btnCopy)

        result = findViewById(R.id.resultTv)

        camera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(intent.resolveActivity(packageManager)!=null){
                startActivityForResult(intent,122)
            }else{
                Toast.makeText(this,"Oops something went wrong!!",Toast.LENGTH_SHORT).show()
            }
        }
        erase.setOnClickListener {
            result.setText("")
        }
        copy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label",result.text.toString())
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this,"Copy to clipboard",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==123 && resultCode== RESULT_OK){
            val extras = data?.extras
            val bitmap = extras?.get("data") as Bitmap
            detectTextUsingMl(bitmap)
        }
    }

    private fun detectTextUsingMl(bitmap: Bitmap) {
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        val image = InputImage.fromBitmap(bitmap,0)

        val result = recognizer.process(image)
            .addOnSuccessListener {visionText->
                result.setText(visionText.text.toString())
            }
            .addOnFailureListener { e->
                Toast.makeText(this,"Oops something went wrong!!",Toast.LENGTH_SHORT).show()
            }
    }
}