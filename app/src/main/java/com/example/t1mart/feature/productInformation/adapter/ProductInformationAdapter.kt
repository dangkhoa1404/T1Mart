package com.example.t1mart.feature.productInformation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import kotlinx.android.synthetic.main.similar_product.view.*
import quicktype.Product

class ProductInformationAdapter(var context: Context,
                                var productInformationList : List<Product>)
    : RecyclerView.Adapter<ProductInformationAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.similar_product, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = productInformationList[position]
        Glide.with(context).load(currentItem.thumbnail).into(holder.itemView.img_thumbnailProduct)
        holder.itemView.tv_brandProduct.text = currentItem.brand
        holder.itemView.tv_titleProduct.text = currentItem.title
        holder.itemView.tv_priceProduct.text = currentItem.price.toString()
        holder.itemView.tv_ratingProduct.text = currentItem.rating.toString()
        var salePrice : Double = currentItem.price!! * 1.0 * (100.0 - currentItem.discountPercentage!!)
        var salePrice2Digrit : Double = Math.round(salePrice)/ 100.0
        holder.itemView.tv_salePriceProduct.text = salePrice2Digrit.toString()
    }

    override fun getItemCount(): Int {
        return productInformationList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}
}