package com.example.adventurekaan.ui.zonas

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.adventurekaan.R
import com.example.adventurekaan.databinding.FragmentZonasContainerBinding
import com.example.adventurekaan.informationModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class ZonasContainer : Fragment() {

    //Variables para la lista
    private lateinit var InformationModel : ArrayList<informationModel>
    private lateinit var imageId: Array<Int>
    private lateinit var title: Array<String>
    private lateinit var text: Array<String>
    lateinit var zonas: Array<LatLng>

    lateinit var img: ImageView
    lateinit var txt : TextView
    lateinit var header : TextView

    private var _binding: FragmentZonasContainerBinding? = null
    private val binding get() = _binding!!

    var posicion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_zonas_container, container, false)
        _binding = FragmentZonasContainerBinding.inflate(inflater, container, false)
        return binding.root
    }


    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        if (arguments != null){
            dataInitialize()

            //Obejtos
            txt = view.findViewById(R.id.text)
            header  = view.findViewById(R.id.title)
            img = view.findViewById(R.id.IconImageView)

            //Posicion
            posicion = arguments?.getInt("3132")!!.toInt()

            //Item
            val currenItem = InformationModel[posicion.toInt()]

            //Insertar texto
            txt.text = currenItem.text.toString()

            //Insertar imagen
            header.text = currenItem.title.toString()

            //Insertar imagen
            binding.IconImageView.scaleType = ImageView.ScaleType.CENTER_CROP
            binding.IconImageView.setImageResource(currenItem.title_img)

            //Variables para el mapa
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(callback)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){
        InformationModel = arrayListOf<informationModel>()

        imageId = arrayOf(
            R.drawable.bg_zonas_c_1,
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

        text = arrayOf<String>(
            getString(R.string.text_museoMaya),
            getString(R.string.text_museoGuerraCastas),
            getString(R.string.text_chichenItza),
            getString(R.string.text_tulum),
            getString(R.string.text_coba),
            getString(R.string.text_xamanHa),
            getString(R.string.text_xcaret),
            getString(R.string.text_uxmal),
            getString(R.string.text_palenque),
            getString(R.string.text_kohunlich),
            getString(R.string.text_sanMiguelito),
            getString(R.string.text_elTajin)
            )

        for(i in imageId.indices){
            val information = informationModel(imageId[i], title[i],text[i])
            InformationModel.add(information)
        }
    }

    //Metodo que carga el mapa
    private val callback = OnMapReadyCallback { googleMap ->
        //val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(zonas[posicion.toInt()]).title(title[posicion.toInt()]))

        // googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))

        //googleMap.addMarker(MarkerOptions().position(chichen).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(zonas[posicion.toInt()]))
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(zonas[posicion.toInt()],7f),
            3000,null
        )
    }

}