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
            supportFragmentManager.popBackStackImmediate()
            if (supportFragmentManager.backStackEntryCount == 0) {
                finish()
                return@setOnClickListener
            }
        }

        findViewById<Button>(R.id.next).setOnClickListener {
           addStep(supportFragmentManager.backStackEntryCount)
        }


        // add a default step
        if (supportFragmentManager.backStackEntryCount == 0) {
            addStep(0)
        }

    }

    private fun addStep(stepNumber: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.settingsStepFrag, IdentifiableFragment.newInstance(stepNumber))
            .addToBackStack(null)
            .commit()
    }

}