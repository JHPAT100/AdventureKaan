package com.example.adventure_kaan.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adventure_kaan.R
import com.example.adventure_kaan.ui.modelos.CardList

class CustomAdapter_v3(
    val Lista:List<CardList>,
    private val itemClickListener: OnClickListener
) : RecyclerView.Adapter<CustomAdapter_v3.ViewHolder>(){

    interface OnClickListener{
        fun onImageClick(image:Int,position:Int)
        fun onItemClick(titulo:String)
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
        holder.itemImage.setImageResource(currenItem.title_img)


        //Para el onClick
        holder.itemView.setOnClickListener { itemClickListener.onItemClick(currenItem.title) }
        holder.itemImage.setOnClickListener { itemClickListener.onImageClick(currenItem.title_img,position) }
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