package com.example.t1mart.feature.productInformation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import kotlinx.android.synthetic.main.product_information.view.*
import quicktype.Product

class ProductInformationTruthAdapter(var context : Context,
                                     var data : Product
)
    : RecyclerView.Adapter<ProductInformationTruthAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_information, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        var currentItem = productInformation[position]
        Glide
            .with(context)
            .load(data.thumbnail)
            .into(holder.itemView.img_thumbnail)
        holder.itemView.tv_brand.text = data.brand
        holder.itemView.tv_title.text = data.title
        holder.itemView.tv_rating.text = data.rating.toString()
        holder.itemView.tv_ratings.text = data.price.toString()
        holder.itemView.tv_reviews.text = data.stock.toString()
        holder.itemView.tv_priceProduct.text = data.price.toString()
        holder.itemView.tv_discountPercentage.text = data.discountPercentage.toString()
        holder.itemView.tv_description.text = data.description
        val salePrice : Double = data.price!! * 1.0 * (100.0 - data.discountPercentage!!)
        val salePrice2Digrit : Double = Math.round(salePrice)/100.0
        holder.itemView.tv_salePrice.text = salePrice2Digrit.toString()
//        holder.itemView.list_item_image.adapter = ImageAdapter(context,
//            data.images!!
//        )
    }

    override fun getItemCount(): Int {
        return 1
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}

}