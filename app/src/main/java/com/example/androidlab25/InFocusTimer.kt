package com.example.androidlab25
import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber

class InFocusTimer(lifecycle: Lifecycle) : LifecycleObserver {

    var secondsCount = 0

    private var handler = Handler()
    private lateinit var runnable: Runnable

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startTimer() {
        runnable = Runnable {
            secondsCount++
            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopTimer() {
        Timber.i("Seconds in focus : $secondsCount")
        handler.removeCallbacks(runnable)
    }
}