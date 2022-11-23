package com.example.adventure_kaan.ui.culture

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adventure_kaan.CustomAdapter
import com.example.adventure_kaan.R
import com.example.adventure_kaan.ui.modelos.CardList
import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CultureFragment : Fragment(),CustomAdapter.OnClickListener {

    //Variables para la lista
    private lateinit var recyclerView: RecyclerView
    private lateinit var ListaCard : ArrayList<CardList>
    private lateinit var adapter: CustomAdapter

    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>

    var posicionLista = 0

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
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_culture, container, false)

    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            CultureFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }

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
        val adapter = CustomAdapter(ListaCard,this)
        recyclerView.adapter = adapter

        /*
        val recyclerView = findViewById<RecyclerView>(R.id.CultureList)
        val adapter = CustomAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        */

    }

    override fun onImageClick(image: Int,position: Int) {
       /*
        //view!!.findNavController().navigate(R.id.cultureContainer)
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        val cultureContainer = CultureContainer()
        val vista = CultureFragment()
        transaction.remove(vista)
        transaction.replace(R.id.nav_host_fragment_activity_main, cultureContainer)
        //transaction.add(R.id.nav_host_fragment_activity_main, cultureContainer)
        transaction.commit()
*/
        //findNavController().navigate(R.id.action_navigation_culture_to_cultureContainer)
       // findNavController().navigate(R.id.navigation_culture)

        //val bundle = Bundle()
        //bundle.putInt("numero",12)
        // activityContenedora?.devolverDato("hola");
        //Nombre del identificador/variable
        val bundle = bundleOf("3132" to position)
        findNavController().navigate(R.id.action_navigation_culture_to_cultureContainer,bundle)


    }

    override fun onItemClick(titulo: String) {
        Toast.makeText(context, "Estas en "+titulo, Toast.LENGTH_SHORT).show()
    }

    private fun dataInitialize(){
        ListaCard = arrayListOf<CardList>()

        imageId = arrayOf(
            R.drawable.historia_card,
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

        for(i in imageId.indices){
            val card = CardList(imageId[i], title[i])
            ListaCard.add(card)
        }
    }

    /*//Metodos para recibor los datos
    interface ComunicadorFragments{
        fun devolverDato(dato:String)
    }

    private var activityContenedora : ComunicadorFragments? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ComunicadorFragments){
            activityContenedora = context
        }else{
            throw RuntimeException(context.toString()
                    +" debe implementar ComunicadorFragments")
        }
    }

    override fun onDetach() {
        super.onDetach()
        activityContenedora = null
    }*/
    //

}