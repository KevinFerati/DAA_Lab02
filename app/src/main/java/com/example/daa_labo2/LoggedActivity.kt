package com.example.daa_labo2;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Permet de journaliser les différents états des activités
 * filles de cette classe avec le nom de l'événemnet ainsi que
 * le nom de la classe appelante.
 *
 * @author Kevin Ferati, Malo Romano, Flavio Sovilla
 *
 */
abstract class LoggedActivity : AppCompatActivity() {

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