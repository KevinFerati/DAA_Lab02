package com.example.daa_labo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.daa_labo2.contracts.PickNameContract

class MainActivity : LoggedActivity() {

    private lateinit var nameText: TextView;

    private val nameContract = registerForActivityResult(PickNameContract()) {
        nameText.text = it ?: "<pas de nom>"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameText = findViewById(R.id.my_textview)
        val launchActivityButton = findViewById<Button>(R.id.button)
        launchActivityButton.setOnClickListener {
            nameContract.launch(null)
        }
    }

}