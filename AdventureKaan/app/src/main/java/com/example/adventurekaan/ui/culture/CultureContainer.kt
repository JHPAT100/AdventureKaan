package com.example.adventurekaan.ui.culture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adventure_kaan.Adaptadores.CustomAdapter_v2
import com.example.adventurekaan.CardList
import com.example.adventurekaan.R
import com.example.adventurekaan.informationModel


class CultureContainer : Fragment() {

    //Variables para la lista
    private lateinit var InformationModel : ArrayList<informationModel>
    private lateinit var imageId: Array<Int>
    private lateinit var title: Array<String>
    private lateinit var text: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_culture_container, container, false)
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
            R.drawable.religion_card,
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