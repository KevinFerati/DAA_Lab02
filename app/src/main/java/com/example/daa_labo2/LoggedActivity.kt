package com.example.daa_labo2;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class LoggedActivity : AppCompatActivity() {

    private fun log(event: String) {
        Log.d("Activity change", "$localClassName : on$event fired")
    }

    override fun onRestart() {
        super.onRestart()
        log("Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("Destroy")
    }

    override fun onStop() {
        super.onStop()
        log("Stop")
    }

    override fun onPause() {
        super.onPause()
        log("Pause")
    }

    override fun onResume() {
        super.onResume()
        log("Resume")
    }

    override fun onStart() {
        super.onStart()
        log("Start")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("Create")
    }

}