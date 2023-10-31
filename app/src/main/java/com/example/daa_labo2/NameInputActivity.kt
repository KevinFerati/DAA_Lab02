package com.example.daa_labo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * Actiité qui permet à l'utilisateur d'entrée du texte. Vérifie l'entrée de l'utilisateur et
 * affiche un message d'erreur si le nom est incorrecte.
 * @author Kevin Ferati, Malo Romano, Flavio Sovilla
 */
class NameInputActivity : LoggedActivity() {

    companion object {
        const val NAME_RESULT_KEY = "NAME_KEY"
    }

    /**
     * Attribue le comportement de sauvegarde au bouton et sauvegarde le nom entré par l'utilisateur
     * à l'activité appelante
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_input)
        val nameInput = findViewById<EditText>(R.id.name)
        val saveBtn = findViewById<Button>(R.id.saveButton)

        saveBtn.setOnClickListener {
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