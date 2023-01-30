package com.example.t1mart.feature.home.adapter.categoriesAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t1mart.R
import com.example.t1mart.api.categories.Category
import kotlinx.android.synthetic.main.categories_home.view.*
import kotlinx.android.synthetic.main.categories_home.view.item
import kotlinx.android.synthetic.main.category_products_recently.view.*

class CategoriesAdapter(val context: Context,
                        val categoriesList: ArrayList<Category>,
                        var listener: onItemClickListener): RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    interface onItemClickListener{
        fun onItemClick(category: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.categories_home, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoriesList[position]
        Glide.with(context).load(currentItem.thumbnail).into(holder.itemView.img_category)
        holder.itemView.tv_category.text = currentItem.category
        holder.itemView.item.setOnClickListener(){
            listener.onItemClick(currentItem.category)
        }
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}

}