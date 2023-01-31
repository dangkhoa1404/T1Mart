package com.example.t1mart.feature.home.adapter.imageMensClothingCombos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import com.example.t1mart.api.mensCombos.Combos
import kotlinx.android.synthetic.main.categories_mens_clothincombos.view.*

class ImageMensCombosAdapter(var context: Context,
                             var mensCombosList: ArrayList<Combos>): RecyclerView.Adapter<ImageMensCombosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.categories_mens_clothincombos, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = mensCombosList[position]
        Glide.with(context).load(currentItem.thumnail).into(holder.itemView.img_mensCombos)
    }

    override fun getItemCount(): Int {
        return mensCombosList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}

}