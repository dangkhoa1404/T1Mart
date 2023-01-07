package com.example.t1mart.feature.categories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t1mart.R
import com.example.t1mart.api.categories.Category
import com.example.t1mart.extension.App
import com.example.t1mart.feature.categories.adapter.CategoryAdapter
import com.example.t1mart.feature.categoryProducts.CategoryProductsActivity
import kotlinx.android.synthetic.main.activity_categories.*
import kotlin.math.log

class CategoriesActivity : AppCompatActivity(), CategoryAdapter.onItemClickListener {
    private lateinit var newArrayList : ArrayList<Category>
    private lateinit var linearLayoutManager :LinearLayoutManager
    lateinit var imgCategory : Array<Int>
    lateinit var tvCategory : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
//        list_categories.setHasFixedSize(true)
//        linearLayoutManager = LinearLayoutManager(this)
//        list_categories.layoutManager = linearLayoutManager
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        imgCategory = arrayOf(
            R.drawable.smartphone,
            R.drawable.laptop,
            R.drawable.fragrances,
            R.drawable.skincare,
            R.drawable.groceries,
            R.drawable.home_decoration,
            R.drawable.furniture,
            R.drawable.tops,
            R.drawable.womens_dresses,
            R.drawable.womens_shoes,
            R.drawable.mens_shirts,
            R.drawable.mens_shoes,
            R.drawable.mens_watches,
            R.drawable.womens_watches,
            R.drawable.womens_bags,
            R.drawable.womens_jewellery,
            R.drawable.sunglasses,
            R.drawable.automotive,
            R.drawable.motorcycle,
            R.drawable.lighting
        )
        tvCategory  = arrayOf(
            "smartphones",
            "laptops",
            "fragrances",
            "skincare",
            "groceries",
            "home-decoration",
            "furniture",
            "tops",
            "womens-dresses",
            "womens-shoes",
            "mens-shirts",
            "mens-shoes",
            "mens-watches",
            "womens-watches",
            "womens-bags",
            "womens-jewellery",
            "sunglasses",
            "automotive",
            "motorcycle",
            "lighting"
        )
        newArrayList = arrayListOf<Category>()
        getCategoriesData()
    }

    private fun getCategoriesData() {
        for(i in imgCategory.indices){
            val category = Category(imgCategory[i], tvCategory[i])
            newArrayList.add(category)
        }
        list_categories.adapter = CategoryAdapter(this, newArrayList, this)
        Log.d("khoa", "chay")
    }

    override fun onItemClick(category: String) {
        //Toast.makeText(this, "${category}", Toast.LENGTH_SHORT).show()
        App.DATA_PRODUCT = category
        Log.d("Khoaaa", "${App.DATA_PRODUCT}")
        startActivity(Intent(this, CategoryProductsActivity::class.java))
    }
}