package com.example.daa_labo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var myTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val launchActivityButton = findViewById<Button>(R.id.button)
        launchActivityButton.setOnClickListener {
            val i = Intent(this, NameInputActivity::class.java)
            startActivity(i) }
    }


}