package com.example.androidlab25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var radioButton1: RadioButton
    lateinit var radioButton2: RadioButton
    lateinit var button5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        textView = findViewById(R.id.clickMe)
        textView.setOnClickListener {
            Toast.makeText(it.context, "Don't click so hard!", Toast.LENGTH_LONG).show()
        }

        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        button5 = findViewById(R.id.button5)

        radioButton1.setOnClickListener{
            button5.visibility = View.VISIBLE
        }

        radioButton2.setOnClickListener {
            button5.visibility = View.INVISIBLE
        }

        button5.setOnClickListener {
            radioButton1.visibility = View.VISIBLE
            radioButton2.visibility = View.VISIBLE
        }
    }

    fun showPreviousActivity(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun showNextActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}