package com.example.t1mart.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.t1mart.R
import com.example.t1mart.api.categories.Category
import com.example.t1mart.api.product.apiProductInterface
import com.example.t1mart.extension.App
import com.example.t1mart.feature.categories.CategoriesActivity
import com.example.t1mart.feature.categoryProducts.CategoryProductsActivity
import com.example.t1mart.feature.home.adapter.ListProductsViewedRecentlyAdapter
import com.example.t1mart.feature.home.adapter.categoriesAdapter.CategoriesAdapter
import com.example.t1mart.feature.home.adapter.productsSuggestedAdapter.ProductsSuggestedAdapter
import com.example.t1mart.feature.productInformation.ProductInformationActivity
import kotlinx.android.synthetic.main.activity_main.*
import quicktype.Total
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),
    ListProductsViewedRecentlyAdapter.onItemClickListener,
    CategoriesAdapter.onItemClickListener,
    ProductsSuggestedAdapter.onItemClickListener{

    val BASE_URL = "https://dummyjson.com/"

    private lateinit var newArrayList: ArrayList<Category>
    lateinit var imgCategory : Array<Int>
    lateinit var tvCategory: Array<String>
    private lateinit var dataTotal : Total
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerViewCategories()
        getProductSuggestedData()
        getProductViewedRecentlytData()
        moveToCategoriesList()
        moveToProductsList()
    }

    private fun setUpRecyclerViewCategories() {
        imgCategory = arrayOf(
            R.drawable.smartphone,
            R.drawable.laptop,
            R.drawable.fragrances,
            R.drawable.skincare,
            R.drawable.groceries,
            R.drawable.lighting,
            R.drawable.furniture,
            R.drawable.tops
        )

        tvCategory = arrayOf(
            "smartphone",
            "laptops",
            "fragrances",
            "skincare",
            "groceries",
            "lighting",
            "furniture",
            "tops"
        )

        newArrayList = arrayListOf<Category>()
        getCategoriesData()
    }

    private fun getCategoriesData() {
        for(i in imgCategory.indices){
            val category = Category(imgCategory[i], tvCategory[i])
            newArrayList.add(category)
        }
        list_categories.adapter = CategoriesAdapter(this@MainActivity, newArrayList, this@MainActivity)
    }

    private fun moveToCategoriesList() {
        tv_seeAll_categories.setOnClickListener(){
            startActivity(Intent(this, CategoriesActivity::class.java))
        }
        tv_shopnow.setOnClickListener(){
            startActivity(Intent(this, CategoriesActivity::class.java))
        }
    }

    private fun getProductSuggestedData() {
        var retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataLaptop()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call: Call<Total?>, response: Response<Total?>) {
                val responseBody = response!!.body()!!
                dataTotal = responseBody
                list_products_suggested.adapter = ProductsSuggestedAdapter(this@MainActivity, dataTotal.products!!, this@MainActivity)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("khoa", "" + t.message)
            }
        })
    }

    private fun getProductViewedRecentlytData() {
        var retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataSmartphone()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call: Call<Total?>, response: Response<Total?>) {
                val responseBody = response!!.body()!!
                dataTotal = responseBody
                list_products_recently.adapter = ListProductsViewedRecentlyAdapter(this@MainActivity, responseBody.products!!, this@MainActivity)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {

            }
        })
    }

    private fun moveToProductsList() {
        tv_seeAll.setOnClickListener(){
            App.DATA_PRODUCT = "smartphones"
            startActivity(Intent(this, CategoryProductsActivity::class.java))
        }
    }

    override fun onItemClick(index: String, category: String) {
        val intent = Intent(this, ProductInformationActivity::class.java)
        intent.putExtra("index", index)
        App.DATA_PRODUCT = category
        startActivity(intent)
    }

    override fun onItemClick(category: String) {
        App.DATA_PRODUCT = category
        startActivity(Intent(this, CategoryProductsActivity::class.java))
    }

    override fun onItemClick_ProductSuggested(index: String, category: String) {
        val intent = Intent(this, ProductInformationActivity::class.java)
        intent.putExtra("index", index)
        App.DATA_PRODUCT = category
        startActivity(intent)
    }


}