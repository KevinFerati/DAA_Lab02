package com.example.daa_labo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.daa_labo2.fragments.StepFragment

/**
 * Activité pour l'étape 3 du labo. Contient 3 boutons de permettant
 * de passer d'une étape à l'autre ou de fermer l'application.
 *
 * @author Kevin Ferati, Malo Romano, Flavio Sovilla
 */
class MainActivityFragments2 : AppCompatActivity() {

    /**
     * Attribue les comportements aux boutons de fermeture, retour et passage
     * à la prochaine étape
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragments2)

        findViewById<Button>(R.id.close).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.back).setOnClickListener {
            supportFragmentManager.popBackStackImmediate()
            if (noStep()) {
                finish()
            }
        }

        findViewById<Button>(R.id.next).setOnClickListener {
            addStep(supportFragmentManager.backStackEntryCount)
        }

        if (noStep()) {
            addStep(0)
        }
    }

    /**
     * Retourne true ou false s'il n'y a pas d'étape ou faux sinon
     */
    private fun noStep() = supportFragmentManager.backStackEntryCount == 0;

    /**
     * Ajoute une étape dans la stack des fragments
     *
     * @param stepNumber numéro de l'étape à affiché
     */
    private fun addStep(stepNumber: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.settingsStepFrag, StepFragment.newInstance(stepNumber))
            .addToBackStack(null)
            .commit()
    }

}