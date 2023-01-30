package com.example.t1mart.feature.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import kotlinx.android.synthetic.main.category_products_recently.view.*
import quicktype.Product

class ListProductsViewedRecentlyAdapter(var context: Context,
                                        var ListProductsViewed : List<Product>,
                                        var listener: onItemClickListener) : RecyclerView.Adapter<ListProductsViewedRecentlyAdapter.MyViewHolder>() {

    interface onItemClickListener{
        fun onItemClick(index: String, category: String)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_products_recently, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = ListProductsViewed[position]
        Glide.with(context).load(currentItem.thumbnail).into(holder.itemView.img_thumbnailProduct)
        holder.itemView.tv_titleProduct.text = currentItem.title
        holder.itemView.tv_categoryProduct.text = currentItem.brand
        holder.itemView.tv_priceProduct.text = currentItem.price.toString()
        var salePrice : Double = currentItem.price!! * 1.0 * (100.0 - currentItem.discountPercentage!!)
        var salePrice2Digrit : Double = Math.round(salePrice)/100.0
        holder.itemView.tv_salePriceProduct.text = salePrice2Digrit.toString()
        holder.itemView.item.setOnClickListener(){
            listener.onItemClick(currentItem.id.toString(), currentItem.category.toString())
        }
    }

    override fun getItemCount(): Int {
        return ListProductsViewed.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}

}