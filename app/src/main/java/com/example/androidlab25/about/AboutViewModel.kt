package com.example.androidlab25.about

import androidx.lifecycle.ViewModel
import timber.log.Timber

class AboutViewModel(message : String) : ViewModel() {

    init {
        Timber.i("Your Message is $message")
    }
}