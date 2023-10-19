package com.example.daa_labo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NameInputActivity : LoggedActivity() {
    companion object {
        val NAME_RESULT_KEY = "NAME_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_input)
        val input = findViewById<EditText>(R.id.name)
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val data = Intent()
            data.putExtra(NAME_RESULT_KEY, input.text.toString())
            setResult(RESULT_OK, data)
            finish()
        }

    }
}