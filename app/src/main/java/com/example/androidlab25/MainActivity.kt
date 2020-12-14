package com.example.androidlab25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var fromSpinner: Spinner
    lateinit var toSpinner: Spinner
    lateinit var fromCurrency : String
    lateinit var toCurrency : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fromSpinner = findViewById(R.id.from)
        toSpinner = findViewById(R.id.to)

        fromSpinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (adapterView != null) {
                    fromCurrency = adapterView.getItemAtPosition(position).toString()
                    println(fromCurrency)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        toSpinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (adapterView != null) {
                    toCurrency = adapterView.getItemAtPosition(position).toString()
                    println(toCurrency)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

    fun showSecondActivity(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}