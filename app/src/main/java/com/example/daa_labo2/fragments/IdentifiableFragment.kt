package com.example.daa_labo2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.daa_labo2.R


private const val ARG_STEP_NUMBER = "step_number"

class IdentifiableFragment : Fragment() {

    private var stepNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stepNumber = it.getInt(ARG_STEP_NUMBER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_identifiable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            stepNumber = it.getInt(ARG_STEP_NUMBER, 0)
        }
        view.findViewById<TextView>(R.id.stepNumber).text = "$stepNumber"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_STEP_NUMBER, stepNumber)
    }

    companion object {
        @JvmStatic
        fun newInstance(step: Int) =
            IdentifiableFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_STEP_NUMBER, step)
                }
            }
    }



}