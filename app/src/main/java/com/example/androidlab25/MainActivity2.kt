package com.example.androidlab25

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var radioButton1: RadioButton
    lateinit var radioButton2: RadioButton

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView = findViewById(R.id.clickMe)
        textView.setOnClickListener {
            Toast.makeText(it.context, "Don't click so hard!", Toast.LENGTH_LONG).show()
        }

        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)

        radioButton1.setOnClickListener{
            radioButton2.text = "Oh, common..."
            radioButton1.text = "Yeah!"
        }

        radioButton2.setOnClickListener {
            radioButton2.text = "Yeah!"
            radioButton1.text = "Seriously?!"
        }
    }

    fun showPreviousActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun showNextActivity(view: View) {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }
}