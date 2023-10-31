package com.example.daa_labo2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.daa_labo2.R


/**
 * Nom du paramètre utilisé lors de la sauvegarde de l'état
 */
private const val ARG_STEP_NUMBER = "step_number"

/**
 * Fragment permettant de représenter une étape lors d'une configuration
 * et identifié par un numéro d'étape.
 */
class StepFragment : Fragment() {

    private var stepNumber = 0

    /**
     * Récupère le numéro d'étape, s'il existe, transféré
     * par l'état passé en paramètre.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stepNumber = it.getInt(ARG_STEP_NUMBER)
        }
    }

    /**
     * Retourne la vue du fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_identifiable, container, false)
    }

    /**
     * Affiche le numéro de l'étape inscrit dans l'état
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            stepNumber = it.getInt(ARG_STEP_NUMBER, 0)
        }
        view.findViewById<TextView>(R.id.stepNumber).text = "$stepNumber"
    }

    /**
     * Sauvegarde le numéro de l'étape
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_STEP_NUMBER, stepNumber)
    }

    companion object {

        /**
         * Permet de créer une nouvelle étape avec le numéro d'état
         * en paramètre
         * @param step Numéro de l'étape à créer
         * @return un nouveau StepFragment dont l'état commence avec le paramètre passé
         */
        @JvmStatic
        fun newInstance(step: Int) =
            StepFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_STEP_NUMBER, step)
                }
            }
    }



}