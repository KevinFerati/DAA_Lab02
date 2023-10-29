package com.example.daa_labo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NameInputActivity : LoggedActivity() {

    companion object {
        val NAME_RESULT_KEY = "NAME_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_input)
        val nameInput = findViewById<EditText>(R.id.name)
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val name = nameInput.text.toString()
            if (name.isBlank()) {
                Toast.makeText(this, "Veuillez entrer un nom", Toast.LENGTH_LONG)
                     .show()
                return@setOnClickListener
            }
            val data = Intent()
            data.putExtra(NAME_RESULT_KEY, name)
            setResult(RESULT_OK, data)
            finish()
        }

    }
}