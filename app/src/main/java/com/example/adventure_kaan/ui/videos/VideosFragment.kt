package com.example.adventure_kaan.ui.videos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adventure_kaan.Adaptadores.CustomAdapter_v2
import com.example.adventure_kaan.Adaptadores.CustomAdapter_v3
import com.example.adventure_kaan.R
import com.example.adventure_kaan.ui.modelos.CardList


// TODO: Rename parameter arguments, choose names that match

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Variables para la lista
private lateinit var recyclerView: RecyclerView
private lateinit var ListaCard : ArrayList<CardList>
private lateinit var adapter: CustomAdapter_v3

lateinit var imageId: Array<Int>
lateinit var title: Array<String>

var posicionLista = 0

class VideosFragment : Fragment(), CustomAdapter_v3.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            VideosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //Metodos para la creacion y interaccion de la lista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.List)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        //cargamos el adapatador de los valores y se lo anexamos al la lista
        val adapter = CustomAdapter_v3(ListaCard,this)
        recyclerView.adapter = adapter
    }

    override fun onImageClick(image: Int,position: Int) {
        val bundle = bundleOf("01" to position)
        findNavController().navigate(R.id.videosWebFragment,bundle)
    }

    override fun onItemClick(titulo: String) {
    }

    private fun dataInitialize(){
        ListaCard = arrayListOf<CardList>()

        imageId = arrayOf(
            R.drawable.img_mayas_v1,
            R.drawable.img_mayas_v1,
            R.drawable.img_mayas_v1,
            R.drawable.img_mayas_v1,
            R.drawable.img_mayas_v1,
        )

        title = arrayOf(
            "Los Mayas en dibujos animados",
            "¿Qué diferencia a los aztecas de los mayas?",
            "Historia Maya",
            "La cultura maya en 3 minutos",
            "El juego sagrado de los mayas",
        )

        for(i in imageId.indices){
            val card = CardList(imageId[i], title[i])
            ListaCard.add(card)
        }
    }


}