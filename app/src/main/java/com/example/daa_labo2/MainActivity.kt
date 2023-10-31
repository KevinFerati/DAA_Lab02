package com.example.daa_labo2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.daa_labo2.contracts.PickNameContract

/**
 * Nom du paramètre du nom entré par l'utilisateur, utilisé
 * dans la gestion de l'état.
 *
 */
private const val ARG_NAME = "param_name"


/**
 * Activité pour l'étape 1 du labo. Contient un message d'accueil pour
 * le client ainsi qu'un bouton permettant d'éditer le nom du client.
 * La communication avec l'activité est géré par PickNameContract.
 * @author Kevin Ferati, Malo Romano, Flavio Sovilla
 */
class MainActivity : LoggedActivity() {

    private var name: String? = null

    private lateinit var nameText: TextView

    /**
     * Contrat de communication entre NameInputActivity et
     * MainActivity. à la terminaison de nameInputActivity, sauvegarde le nom entré par
     * l'utilisateur
     */
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

    /**
     * Change le texte de bienvenu par celui de l'état sauvegardé
     */
    override fun onResume() {
        super.onResume()
        if (!name.isNullOrBlank()) {
            nameText.text = "Bonjour, $name !"
        }
    }

    /**
     * Sauvegarde le nom de l'utilisateur
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_NAME, name)
    }

}