package com.example.adventure_kaan

import android.content.Context
import android.graphics.ColorSpace.Model
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.adventure_kaan.ui.culture.CultureContainer

class CustomAdapter(
    private val itemClickListener:OnClickListener
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    val titles = arrayOf("Historia","Religión","Arte","Agricultura","Astronomía","Calendario")
    val subtitles = arrayOf("Entra y conoce","Entra y conoce","Entra y conoce","Entra y conoce","Entra y conoce","Entra y conoce")
    val images = intArrayOf(R.drawable.fondo_prueba_371_73,
        R.drawable.fondo_prueba_371_73,
        R.drawable.fondo_prueba_371_73,
        R.drawable.fondo_prueba_371_73,
        R.drawable.fondo_prueba_371_73,
        R.drawable.fondo_prueba_371_73
    )

    interface OnClickListener{
        fun onImageClick(image:Int)
        fun onItemClick(titulo:String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_v2,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemTitle.text = titles[position]
        holder.itemImage.setImageResource(images[position])


        //Para el onClick
        holder.itemView.setOnClickListener { itemClickListener.onItemClick(titles[position]) }
        holder.itemImage.setOnClickListener { itemClickListener.onImageClick(images[position]) }
        //

    }



    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle: TextView

        init{
            itemImage = itemView.findViewById(R.id.IconImageView)
            itemTitle = itemView.findViewById(R.id.Title)

        }

    }
}