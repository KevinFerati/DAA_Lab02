package com.example.daa_labo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/**
 * Activité pour l'étape 2 du labo. Ne fait rien de particulier, si ce npest
 * afficher la vue "activity_main_fragments".
 * @author Kevin Ferati, Malo Romano, Flavio Sovilla
 */
class MainActivityFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragments)
    }
}