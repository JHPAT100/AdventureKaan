package com.app.adventurekaan.ui.culture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.adventure_kaan.Adaptadores.CustomAdapter_v2
import com.app.adventurekaan.CardList
import com.app.adventurekaan.R
import com.app.adventurekaan.databinding.FragmentCultureBinding

class CultureFragment : Fragment(),CustomAdapter_v2.OnClickListener {


    //Variables para la lista
    private lateinit var recyclerView: RecyclerView
    private lateinit var ListaCard : ArrayList<CardList>
    private lateinit var adapter: CustomAdapter_v2

    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>

    var posicionLista = 0

    private var _binding: FragmentCultureBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_culture, container, false)

        _binding = FragmentCultureBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Clases para la lista
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

        val bundle = bundleOf("3132" to position)
        findNavController().navigate(R.id.action_cultureFragment_to_cultureContainer,bundle)

    }

    override fun onItemClick(titulo: String, position: Int) {
        val bundle = bundleOf("3132" to position)
        findNavController().navigate(R.id.action_cultureFragment_to_cultureContainer,bundle)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){
        ListaCard = arrayListOf<CardList>()

        imageId = arrayOf(
            R.drawable.bg_culture_logo_1,
            R.drawable.bg_culture_logo_2,
            R.drawable.bg_culture_logo_3,
            R.drawable.bg_culture_logo_4,
            R.drawable.bg_culture_logo_5,
            R.drawable.bg_culture_logo_6
        )

        title = arrayOf(
            "Historia",
            "Religión",
            "Arte",
            "Agricultura",
            "Astronomía",
            "Calendario"
        )

        for(i in imageId.indices){
            val card = CardList(imageId[i], title[i])
            ListaCard.add(card)
        }
    }

}