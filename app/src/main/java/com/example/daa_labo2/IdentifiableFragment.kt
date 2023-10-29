package com.example.daa_labo2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_STEP_NUMBER = "step_number"
class IdentifiableFragment : Fragment() {

    private var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_STEP_NUMBER)
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
        view.findViewById<TextView>(R.id.stepNumber).text = "$id"
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