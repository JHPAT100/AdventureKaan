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
import com.example.adventurekaan.databinding.FragmentCultureContainerBinding
import com.example.adventurekaan.databinding.FragmentPrimerBinding
import com.example.adventurekaan.informationModel


class CultureContainer : Fragment() {

    //Variables para la lista
    private lateinit var InformationModel : ArrayList<informationModel>
    private lateinit var imageId: Array<Int>
    private lateinit var title: Array<String>
    private lateinit var text: Array<String>

    private var _binding: FragmentCultureContainerBinding? = null
    private val binding get() = _binding!!

    lateinit var img: ImageView
    lateinit var txt : TextView
    lateinit var header : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_culture_container, container, false)
        _binding = FragmentCultureContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            dataInitialize()
            //val numFragmento = arguments!!.getInt("numero")
            //Toast.makeText(context, arguments?.getInt("3132").toString(), Toast.LENGTH_SHORT).show()
            txt = view.findViewById(R.id.text)
            header  = view.findViewById(R.id.title)
            img = view.findViewById(R.id.IconImageView)
            val posicion : Int = arguments?.getInt("3132")!!.toInt()
            //Toast.makeText(context, posicion.toString(), Toast.LENGTH_SHORT).show()
            val currenItem = InformationModel[posicion.toInt()]
            txt.text = currenItem.text.toString()
            header.text = currenItem.title.toString()

            //Insertar imagen
            binding.IconImageView.scaleType = ImageView.ScaleType.CENTER_CROP
            binding.IconImageView.setImageResource(currenItem.title_img)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){
        InformationModel = arrayListOf<informationModel>()

        imageId = arrayOf(
            R.drawable.bg_culture_1,
            R.drawable.bg_culture_2,
            R.drawable.bg_culture_3,
            R.drawable.bg_culture_4,
            R.drawable.bg_culture_5,
            R.drawable.bg_culture_6
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