package com.example.daa_labo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivityFragments2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragments2)

        findViewById<Button>(R.id.close).setOnClickListener {
            finish()
        }
        findViewById<Button>(R.id.back).setOnClickListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                finish()
                return@setOnClickListener
            }
            supportFragmentManager.popBackStack()
        }

        findViewById<Button>(R.id.next).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.settingsStepFrag, IdentifiableFragment.newInstance(supportFragmentManager.backStackEntryCount))
                .addToBackStack(null)
                .commit()
        }

    }
}