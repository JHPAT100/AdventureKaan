package com.example.adventurekaan.ui.videos

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
import com.example.adventurekaan.CardList
import com.example.adventurekaan.R
import com.example.adventurekaan.databinding.FragmentPrimerBinding
import com.example.adventurekaan.databinding.FragmentVideosBinding

class VideosFragment : Fragment(), CustomAdapter_v2.OnClickListener{

    //Variables para la lista
    private lateinit var recyclerView: RecyclerView
    private lateinit var ListaCard : ArrayList<CardList>
    private lateinit var adapter: CustomAdapter_v2

    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>

    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_videos, container, false)
        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        return binding.root
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
        val adapter = CustomAdapter_v2(ListaCard,this)
        recyclerView.adapter = adapter
    }

    override fun onImageClick(image: Int,position: Int) {
        val bundle = bundleOf("01" to position)
        findNavController().navigate(R.id.action_videosFragment_to_videosContainer,bundle)
    }

    override fun onItemClick(titulo: String) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){
        ListaCard = arrayListOf<CardList>()

        imageId = arrayOf(
            R.drawable.bg_videos_1,
            R.drawable.bg_videos_2,
            R.drawable.bg_videos_3,
            R.drawable.bg_videos_4,
            R.drawable.bg_videos_5,
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