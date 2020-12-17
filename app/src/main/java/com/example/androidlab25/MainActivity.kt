package com.example.androidlab25

import com.example.androidlab25.about.AboutFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import mainLogic.BlankFragment1
import com.example.androidlab25.terms.TermsFragment
import timber.log.Timber

const val KEY_REVENUE = "key_revenue"

class MainActivity : AppCompatActivity() {

    private var revenue = 10
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration
    private  lateinit var lifeCycleTimer: LifeCycleTimer
    private lateinit var inFocusTimer: InFocusTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.i("onCreate called")
        lifeCycleTimer = LifeCycleTimer(this.lifecycle)
        inFocusTimer = InFocusTimer(this.lifecycle)
        if (savedInstanceState != null) {
            revenue = savedInstanceState.getInt(KEY_REVENUE)
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_REVENUE, revenue)
        Timber.i("onSaveInstanceState called")
    }

    /** Lifecycle Methods **/
    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
//        lifeCycleTimer.stopTimer()
    }

    override fun onDestroy() {
        val inFocusSeconds = inFocusTimer.secondsCount
        val generalSeconds = lifeCycleTimer.secondsCount
        val appWasInFocus = (inFocusSeconds.toDouble() / generalSeconds.toDouble()) * 100
        Timber.i("$appWasInFocus% - App was in focus")
        super.onDestroy()
        Timber.i("onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }
}