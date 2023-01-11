package com.example.t1mart.feature.categoryProducts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import kotlinx.android.synthetic.main.categories.view.*
import kotlinx.android.synthetic.main.category_products.view.*
import kotlinx.android.synthetic.main.category_products.view.item
import quicktype.Product

class ProductsAdapter(var context : Context,
                      var ProductsList : List<Product>, var listener : onItemClickListener) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    interface onItemClickListener{
        fun onItemClick(index: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_products, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = ProductsList[position]
        Glide.with(context).load(currentItem.thumbnail).into(holder.itemView.img_thumbnailProduct)
        holder.itemView.tv_titleProduct.text = currentItem.title
        holder.itemView.tv_categoryProduct.text = currentItem.category
        holder.itemView.tv_priceProduct.text = currentItem.price.toString()
        holder.itemView.tv_ratingProduct.text = currentItem.rating.toString()
        var salePrice : Double = currentItem.price!! * 1.0 * (100.0 - currentItem.discountPercentage!!)
        val safelPrice2Digrit : Double = Math.round(salePrice)/100.0
        holder.itemView.tv_salePriceProduct.text = safelPrice2Digrit.toString()
        holder.itemView.item.setOnClickListener(){
            listener.onItemClick(currentItem.id.toString())
        }
    }

    override fun getItemCount(): Int {
        return ProductsList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}
}