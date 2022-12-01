package com.example.adventure_kaan.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.adventurekaan.CardList
import com.example.adventurekaan.R

class CustomAdapter_v2(
    val Lista:List<CardList>,
    private val itemClickListener: OnClickListener,
) : RecyclerView.Adapter<CustomAdapter_v2.ViewHolder>(){

    interface OnClickListener{
        fun onImageClick(image:Int,position:Int)
        fun onItemClick(titulo:String,position:Int)
        //fun onItemClick(card:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_v3,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return Lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currenItem = Lista[position]
        holder.itemTitle.text = currenItem.title

        //Insertar imagen
        holder.itemImage.setImageResource(currenItem.title_img)


        //Para el onClick
        //Obejeto
        holder.itemView.setOnClickListener { itemClickListener.onItemClick(currenItem.title,position) }
        //holder.itemView.setOnClickListener(itemClickListener.onItemClick(itemCard))
        //Imagen
        holder.itemImage.setOnClickListener { itemClickListener.onImageClick(currenItem.title_img,position) }
        //

    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle: TextView
        lateinit var itemCard : CardView

        init{
            itemCard = itemView.findViewById(R.id.CardPrincipal)
            itemImage = itemView.findViewById(R.id.IconImageView)
            itemTitle = itemView.findViewById(R.id.Title)

        }

    }
}