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
import androidx.recyclerview.widget.RecyclerView
import com.example.adventure_kaan.CustomAdapter
import com.example.adventure_kaan.R
import com.example.adventure_kaan.ui.modelos.CardList
import com.example.adventure_kaan.ui.modelos.informationModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Variables para la lista
private lateinit var InformationModel : ArrayList<informationModel>
private lateinit var imageId: Array<Int>
private lateinit var title: Array<String>
private lateinit var text: Array<String>


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
            dataInitialize()
            //val numFragmento = arguments!!.getInt("numero")
            //Toast.makeText(context, arguments?.getInt("3132").toString(), Toast.LENGTH_SHORT).show()
            val text : TextView = view.findViewById(R.id.text)
            val title : TextView = view.findViewById(R.id.title)
            val img : ImageView = view.findViewById(R.id.IconImageView)
            val posicion : Int = arguments?.getInt("3132")!!.toInt()
            //Toast.makeText(context, posicion.toString(), Toast.LENGTH_SHORT).show()
            val currenItem = InformationModel[posicion.toInt()]
            text.text = currenItem.text.toString()
            title.text = currenItem.title.toString()
            img.setImageResource(currenItem.title_img)
        }


    }

    private fun dataInitialize(){
        InformationModel = arrayListOf<informationModel>()

        imageId = arrayOf(
            R.drawable.fondo,
            R.drawable.religion_card,
            R.drawable.arte_card,
            R.drawable.agricultura_card,
            R.drawable.fondo_prueba_371_73,
            R.drawable.fondo_prueba_371_73
        )

        title = arrayOf(
            "Historia",
            "Religión",
            "Arte",
            "Agricultura",
            "Astronomía",
            "Calendario"
        )

        text = arrayOf<String>(
            getString(R.string.text_historia),
            getString(R.string.text_religion),
            getString(R.string.text_arte),
            getString(R.string.text_agricultura),
            getString(R.string.text_astronomia),
            getString(R.string.text_calendario),

        )

        for(i in imageId.indices){
            val information = informationModel(imageId[i], title[i],text[i])
            InformationModel.add(information)
        }
    }




}