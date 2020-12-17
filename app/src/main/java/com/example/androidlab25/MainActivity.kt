package com.example.androidlab25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        lateinit var fragment: Fragment
        if (item?.itemId == R.id.share_menu) {
            val shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT, "You shared data")
                this.type = "text/plain"
            }
            startActivity(shareIntent)
        } else if (item.itemId == R.id.about_menu) {
            fragment = AboutFragment()
            val fragmentManager = supportFragmentManager
            val fragmentTransition = fragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.fr_place, fragment)
            fragmentTransition.commit()
            val mainFragment = BlankFragment1()
            mainFragment.view?.visibility = View.GONE
        } else if (item.itemId == R.id.main_page) {
            fragment = BlankFragment1()
            val fragmentManager = supportFragmentManager
            val fragmentTransition = fragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.fr_place, fragment)
            fragmentTransition?.commit()
        } else if (item.itemId == R.id.terms_menu) {
            fragment = TermsFragment()
            val fragmentManager = supportFragmentManager
            val fragmentTransition = fragmentManager.beginTransaction()
            fragmentTransition.replace(R.id.fr_place, fragment)
            fragmentTransition?.commit()
        }else {
            return super.onOptionsItemSelected(item)
        }
        return true
    }
}