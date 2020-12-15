package com.example.androidlab25

import android.content.Intent
import android.icu.util.CurrencyAmount
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var fromSpinner: Spinner
    lateinit var toSpinner: Spinner
    lateinit var fromCurrency : String
    lateinit var toCurrency : String
    lateinit var amount: TextView
    lateinit var convertedAmountField : TextView
    var rate by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fromSpinner = findViewById(R.id.from)
        toSpinner = findViewById(R.id.to)
        amount = findViewById(R.id.amount)
        convertedAmountField = findViewById(R.id.converted_amount)

        fromSpinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (adapterView != null) {
                    fromCurrency = adapterView.getItemAtPosition(position).toString()
                    println(fromCurrency)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        toSpinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (adapterView != null) {
                    toCurrency = adapterView.getItemAtPosition(position).toString()
                    println(toCurrency)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }



    fun showSecondActivity(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun convert(view: View) {

        val reverseCurrency = fromCurrency
        fromCurrency = toCurrency
        toCurrency = reverseCurrency
        println("fromCurrency is $fromCurrency")
        println("toCurrency is $toCurrency")
        val rate = checkRate()
        val doubleAmount: Double = amount.text.toString().toDouble()
        println(rate)
        convertedAmountField.text = (doubleAmount*rate).toString()
    }

    private fun checkRate(): Double {
        if(fromCurrency == "UAH") {
            println("perviy nah")
            if (toCurrency == "UAH") {
                return 1.0
            } else if (toCurrency == "USD") {
                return 0.036
            } else if (toCurrency == "EUR") {
                return 0.03
            } else if (toCurrency == "INR") {
                return 2.65
            } else if (toCurrency == "JPY") {
                return 3.71
            } else if (toCurrency == "RUB") {
                return 2.6
            } else if (toCurrency == "TRY") {
                return 0.28
            } else if (toCurrency == "RON") {
                return 0.14
            } else if (toCurrency == "MNT") {
                println("here")
                return 102.68
            } else if (toCurrency == "CNY") {
                return 0.23
            }
        } else if (fromCurrency == "USD") {
            if (toCurrency == "UAH") {
                return 27.12
            } else if (toCurrency == "USD") {
                return 1.0
            } else if (toCurrency == "EUR") {
                return 0.82
            } else if (toCurrency == "INR") {
                return 73.55
            } else if (toCurrency == "JPY") {
                return 103.64
            } else if (toCurrency == "RUB") {
                return 73.75
            } else if (toCurrency == "TRY") {
                return 7.83
            } else if (toCurrency == "RON") {
                return 4.00
            } else if (toCurrency == "MNT") {
                return 2845.0
            } else if (toCurrency == "CNY") {
                return 6.5
            }
        } else if (fromCurrency == "EUR") {
            if (toCurrency == "UAH") {
                return 32.68
            } else if (toCurrency == "USD") {
                return 1.2
            } else if (toCurrency == "EUR") {
                return 1.0
            } else if (toCurrency == "INR") {
                return 89.37
            } else if (toCurrency == "JPY") {
                return 125.99
            } else if (toCurrency == "RUB") {
                return 89.18
            } else if (toCurrency == "TRY") {
                return 9.52
            } else if (toCurrency == "RON") {
                return 4.86
            } else if (toCurrency == "MNT") {
                return 3463.81
            } else if (toCurrency == "CNY") {
                return 7.95
            }
        } else if (fromCurrency == "INR") {
            if (toCurrency == "UAH") {
                return 0.37
            } else if (toCurrency == "USD") {
                return 0.013
            } else if (toCurrency == "EUR") {
                return 0.011
            } else if (toCurrency == "INR") {
                return 1.0
            } else if (toCurrency == "JPY") {
                return 1.4
            } else if (toCurrency == "RUB") {
                return 0.99
            } else if (toCurrency == "TRY") {
                return 0.10
            } else if (toCurrency == "RON") {
                return 0.05
            } else if (toCurrency == "MNT") {
                return 38.73
            } else if (toCurrency == "CNY") {
                return 0.08
            }
        } else if (fromCurrency == "JPY") {
            if (toCurrency == "UAH") {
                return 0.26
            } else if (toCurrency == "USD") {
                return 0.0096
            } else if (toCurrency == "EUR") {
                return 0.0079
            } else if (toCurrency == "INR") {
                return 0.7
            } else if (toCurrency == "JPY") {
                return 1.0
            } else if (toCurrency == "RUB") {
                return 0.7
            } else if (toCurrency == "TRY") {
                return 0.07
            } else if (toCurrency == "RON") {
                return 0.03
            } else if (toCurrency == "MNT") {
                return 27.49
            } else if (toCurrency == "CNY") {
                return 0.063
            }
        } else if (fromCurrency == "RUB") {
            if (toCurrency == "UAH") {
                return 0.37
            } else if (toCurrency == "USD") {
                return 0.01
            } else if (toCurrency == "EUR") {
                return 0.011
            } else if (toCurrency == "INR") {
                return 1.0026
            } else if (toCurrency == "JPY") {
                return 1.41
            } else if (toCurrency == "RUB") {
                return 1.0
            } else if (toCurrency == "TRY") {
                return 0.10
            } else if (toCurrency == "RON") {
                return 0.054
            } else if (toCurrency == "MNT") {
                return 38.83
            } else if (toCurrency == "CNY") {
                return 0.089
            }
        } else if (fromCurrency == "TRY") {
            if (toCurrency == "UAH") {
                return 3.54
            } else if (toCurrency == "USD") {
                return 0.12
            } else if (toCurrency == "EUR") {
                return 0.10
            } else if (toCurrency == "INR") {
                return 9.38
            } else if (toCurrency == "JPY") {
                return 13.22
            } else if (toCurrency == "RUB") {
                return 9.3
            } else if (toCurrency == "TRY") {
                return 1.1
            } else if (toCurrency == "RON") {
                return 0.51
            } else if (toCurrency == "MNT") {
                return 363.56
            } else if (toCurrency == "CNY") {
                return 0.83
            }
        } else if (fromCurrency == "RON") {
            if (toCurrency == "UAH") {
                return 6.9
            } else if (toCurrency == "USD") {
                return 0.25
            } else if (toCurrency == "EUR") {
                return 0.20
            } else if (toCurrency == "INR") {
                return 18.36
            } else if (toCurrency == "JPY") {
                return 25.88
            } else if (toCurrency == "RUB") {
                return 18.31
            } else if (toCurrency == "TRY") {
                return 1.95
            } else if (toCurrency == "RON") {
                return 1.1
            } else if (toCurrency == "MNT") {
                return 711.43
            } else if (toCurrency == "CNY") {
                return 1.63
            }
        } else if (fromCurrency == "MNT") {
            if (toCurrency == "UAH") {
                return 0.0097
            } else if (toCurrency == "USD") {
                return 0.0004
            } else if (toCurrency == "EUR") {
                return 0.0003
            } else if (toCurrency == "INR") {
                return 0.025
            } else if (toCurrency == "JPY") {
                return 0.036
            } else if (toCurrency == "RUB") {
                return 0.025
            } else if (toCurrency == "TRY") {
                return 0.0028
            } else if (toCurrency == "RON") {
                return 0.0014
            } else if (toCurrency == "MNT") {
                return 1.1
            } else if (toCurrency == "CNY") {
                return 0.0023
            }
        } else if (fromCurrency == "CNY") {
            if (toCurrency == "UAH") {

            } else if (toCurrency == "USD") {
                return 0.15
            } else if (toCurrency == "EUR") {
                return 0.12
            } else if (toCurrency == "INR") {
                return 11.24
            } else if (toCurrency == "JPY") {
                return 15.86
            } else if (toCurrency == "RUB") {
                return 11.21
            } else if (toCurrency == "TRY") {
                return 1.19
            } else if (toCurrency == "RON") {
                return 0.6124
            } else if (toCurrency == "MNT") {
                return 435.661
            } else if (toCurrency == "CNY") {
                return 1.0
            }
        }
        return 0.0
    }
}