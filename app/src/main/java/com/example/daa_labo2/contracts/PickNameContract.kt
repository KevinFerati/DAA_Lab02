package com.example.daa_labo2.contracts;

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.daa_labo2.NameInputActivity

/**
 * Contrat entre MainActivity et nameInputActivity pour la transmission du om entré par l'utilisateur
 * @author Kevin Ferati, Malo Romano, Flavio Sovilla
 */
class PickNameContract : ActivityResultContract<Void?, String?>() {
    override fun createIntent(context: Context, input: Void?)
        = Intent(context, NameInputActivity::class.java)


    /**
     * Retourne le nom entré par l'utilisateur dans NameInputActivity
     */
    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }

        return intent?.getStringExtra(NameInputActivity.NAME_RESULT_KEY)

    }

}
