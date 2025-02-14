package com.app.adventurekaan.ui.zonas

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
import com.app.adventurekaan.databinding.FragmentZonasBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ZonasFragment : Fragment(), CustomAdapter_v2.OnClickListener {


    //Variables para la lista
    private lateinit var recyclerView: RecyclerView
    private lateinit var ListaCard : ArrayList<CardList>
    private lateinit var adapter: CustomAdapter_v2

    lateinit var imageId: Array<Int>
    lateinit var zonas: Array<LatLng>
    lateinit var title: Array<String>

    private var _binding: FragmentZonasBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_zonas, container, false)
        _binding = FragmentZonasBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Metodos para la creacion y interaccion de la lista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Varaiables para el mapa
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        //Varaibles para la lista
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.List)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        //cargamos el adapatador de los valores y se lo anexamos al la lista
        val adapter = CustomAdapter_v2(ListaCard,this)
        recyclerView.adapter = adapter

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){
        ListaCard = arrayListOf<CardList>()

        imageId = arrayOf(
            R.drawable.bg_zonas_1,
            R.drawable.bg_zonas_2,
            R.drawable.bg_zonas_3,
            R.drawable.bg_zonas_4,
            R.drawable.bg_zonas_5,
            R.drawable.bg_zonas_6,
            R.drawable.bg_zonas_7,
            R.drawable.bg_zonas_8,
            R.drawable.bg_zonas_9,
            R.drawable.bg_zonas_10,
            R.drawable.bg_zonas_11,
            R.drawable.bg_zonas_12,
        )

        zonas = arrayOf(
            //"Museo Maya"
            LatLng(19.5774805,-88.0454902),
            // "Museo Guerra de Castas"
            LatLng(20.1968173,-88.3750887),
            //"Chichén Itzá"
            LatLng(20.6791414,-88.5682953),
            // "Tulum"
            LatLng(20.2149473,-87.4297205),
            // "Coba"
            LatLng(20.4912248,-87.7326779),
            // "Xaman-Ha"
            LatLng(20.614579,-87.0832679),
            // "Xcaret"
            LatLng(20.5790629,-87.1195703),
            // "Uxmal"
            LatLng(20.3588291,-89.7881701),
            // "Palenque"
            LatLng(17.4847748,-92.0480836),
            // "Kohunlich"
            LatLng(18.4207335,-88.7926422),
            // "San Miguelito"
            LatLng(21.0708202,-86.77892),
            // "El Tajin"
            LatLng(20.3821163,-97.4661878),
        )


        title = arrayOf(
            "Museo Maya",
            "Museo Guerra de Castas",
            "Chichén Itzá",
            "Tulum",
            "Coba",
            "Xaman-Ha",
            "Xcaret",
            "Uxmal",
            "Palenque",
            "Kohunlich",
            "San Miguelito",
            "El Tajin",
        )

        for(i in imageId.indices){
            val card = CardList(imageId[i], title[i])
            ListaCard.add(card)
        }

    }


    //Metodo que carga el mapa
    private val callback = OnMapReadyCallback { googleMap ->
        //val sydney = LatLng(-34.0, 151.0)

        for (contador in 0..(zonas.size-1)) {
            googleMap.addMarker(MarkerOptions().position(zonas[contador]).title(title[contador]))
        }
       // googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))

        //googleMap.addMarker(MarkerOptions().position(chichen).title("Marker in Sydney"))
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(Museo_Maya))
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(zonas[0],5f),
            3000,null
        )
    }

    override fun onImageClick(image: Int, position: Int) {
        val bundle = bundleOf("3132" to position)
        findNavController().navigate(R.id.action_zonasFragment_to_zonasContainer,bundle)
    }

    override fun onItemClick(titulo: String, position: Int) {
        val bundle = bundleOf("3132" to position)
        findNavController().navigate(R.id.action_zonasFragment_to_zonasContainer,bundle)
    }


}