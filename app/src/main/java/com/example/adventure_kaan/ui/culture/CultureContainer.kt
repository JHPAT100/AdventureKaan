package com.example.adventure_kaan.ui.culture

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adventure_kaan.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CultureContainer : Fragment(){
    //, CultureFragment.ComunicadorFragments
    private var param1: String? = null
    private var param2: String? = null

    /*override fun devolverDato(dato: Int) {

        img.setImageResource(dato)

    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_culture_container, container, false)


    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            CultureContainer().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            //val numFragmento = arguments!!.getInt("numero")
            Toast.makeText(context, arguments?.getInt("3132").toString(), Toast.LENGTH_SHORT).show()
            val te : TextView = view.findViewById(R.id.textView)
            te.text = arguments?.getInt("3132").toString()
        }


    }


}