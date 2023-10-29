package com.example.daa_labo2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.daa_labo2.contracts.PickNameContract
private const val ARG_NAME = "param_name"

class MainActivity : LoggedActivity() {

    private var name: String? = null

    private lateinit var nameText: TextView
    private val nameContract = registerForActivityResult(PickNameContract()) {
        name = it

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            name = savedInstanceState.getString(ARG_NAME, name)
        }
        nameText = findViewById(R.id.nameText)



        val launchActivityButton = findViewById<Button>(R.id.editNameButton)
        launchActivityButton.setOnClickListener {
            nameContract.launch(null)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!name.isNullOrBlank()) {
            nameText.text = "Bonjour, $name !"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_NAME, name)
    }

}