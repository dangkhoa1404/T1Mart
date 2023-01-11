package com.example.t1mart.feature.productInformation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter(
    var context: Context,
    var image: List<String>
): RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageDetail = image[position]
        Glide.with(context).load(imageDetail).into(holder.itemView.image_detail)
        holder.itemView.image_detail.setOnClickListener {
            Log.d("tung2", "${position}")
        }
    }

    override fun getItemCount(): Int {
        Log.d("tung2", "${image.size}")
        return image.size
    }
}