package com.example.androidlab25.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class AboutViewModelFactory(private val message: String) :ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AboutViewModel::class.java)) {
            return AboutViewModel(message) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}