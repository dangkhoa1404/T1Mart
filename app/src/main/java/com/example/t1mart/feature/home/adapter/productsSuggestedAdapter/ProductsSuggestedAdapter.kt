package com.example.t1mart.feature.home.adapter.productsSuggestedAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import kotlinx.android.synthetic.main.category_products_suggested.view.*
import quicktype.Product

class ProductsSuggestedAdapter(var context: Context,
                               var listProductsSuggested: List<Product>, var listener: onItemClickListener): RecyclerView.Adapter<ProductsSuggestedAdapter.MyViewHolder>() {

    interface onItemClickListener{
        fun onItemClick_ProductSuggested(index: String, category: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_products_suggested, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = listProductsSuggested[position]
        Glide.with(context).load(currentItem.thumbnail).into(holder.itemView.img_thumbnailProduct)
        holder.itemView.tv_titleProduct.text = currentItem.title
        holder.itemView.tv_categoryProduct.text = currentItem.brand
        holder.itemView.tv_priceProduct.text = currentItem.price.toString()
        holder.itemView.tv_ratingProduct.text = currentItem.rating.toString()
        var saleprice : Double = currentItem.price!! * 1.0 * (100.0 - currentItem.discountPercentage!!)
        var saleprice2Digrit : Double = Math.round(saleprice)/100.0
        holder.itemView.tv_salePriceProduct.text = saleprice2Digrit.toString()
        holder.itemView.item.setOnClickListener(){
            listener.onItemClick_ProductSuggested(currentItem.id.toString(), currentItem.category.toString())
        }
    }

    override fun getItemCount(): Int {
        return listProductsSuggested.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}
}