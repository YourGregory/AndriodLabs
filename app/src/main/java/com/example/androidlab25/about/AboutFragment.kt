package com.example.androidlab25.about

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.androidlab25.R

class AboutFragment : Fragment() {

    private lateinit var viewModel: AboutViewModel
    private lateinit var viewModelFactory: AboutViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFactory = AboutViewModelFactory("Greetings, user!")
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(AboutViewModel::class.java)
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        return inflater.inflate(R.menu.menu, menu)
    }
}