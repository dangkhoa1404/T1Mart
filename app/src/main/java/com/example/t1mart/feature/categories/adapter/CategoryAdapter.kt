package com.example.t1mart.feature.categories.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import com.example.t1mart.api.categories.Category
import com.example.t1mart.feature.categoryProducts.CategoryProductsActivity
import kotlinx.android.synthetic.main.categories.view.*

class CategoryAdapter(val context: Context,
                      private val categoryList: ArrayList<Category>, var listener: onItemClickListener) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    interface onItemClickListener{
        fun onItemClick(category : String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.categories, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoryList[position]
        Glide.with(context).load(currentItem.thumbnail).into(holder.itemView.img_category)
        //holder.itemView.img_category.setImageResource(currentItem.thumbnail)
        holder.itemView.tv_category.text = currentItem.category
        holder.itemView.item.setOnClickListener(){
//            var i = Intent(context, CategoryProductsActivity::class.java)
//            i.putExtra("page", position)
//            context.startActivity(i)
            listener.onItemClick(currentItem.category)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}
}