package com.example.t1mart.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.t1mart.R
import com.example.t1mart.api.categories.Category
import com.example.t1mart.api.mensCombos.Combos
import com.example.t1mart.api.product.apiProductInterface
import com.example.t1mart.extension.App
import com.example.t1mart.feature.categories.CategoriesActivity
import com.example.t1mart.feature.categoryProducts.CategoryProductsActivity
import com.example.t1mart.feature.home.adapter.ListProductsViewedRecentlyAdapter
import com.example.t1mart.feature.home.adapter.categoriesAdapter.CategoriesAdapter
import com.example.t1mart.feature.home.adapter.image.ImageSliderAdapter
import com.example.t1mart.feature.home.adapter.imageMensClothingCombos.ImageMensCombosAdapter
import com.example.t1mart.feature.home.adapter.productsSuggestedAdapter.ProductsSuggestedAdapter
import com.example.t1mart.feature.productInformation.ProductInformationActivity
import kotlinx.android.synthetic.main.activity_main.*
import quicktype.Total
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.abs

class MainActivity : AppCompatActivity(),
    ListProductsViewedRecentlyAdapter.onItemClickListener,
    CategoriesAdapter.onItemClickListener,
    ProductsSuggestedAdapter.onItemClickListener{

    val BASE_URL = "https://dummyjson.com/"

    //Image Slider
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter: ImageSliderAdapter

    //Api to RecyclerView
    private lateinit var newArrayList: ArrayList<Category>
    lateinit var imgCategory : Array<Int>
    lateinit var tvCategory: Array<String>
    private lateinit var dataTotal : Total
    //mens Combos
    private lateinit var combosArrayList: ArrayList<Combos>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Image Slider
        setDataForViewPager2()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
            }
        })

        //Set up Categories, Products
        setUpRecyclerViewCategories()
        setUpMensCombosData()
        getProductSuggestedData()
        getProductViewedRecentlytData()
        moveToCategoriesList()
        moveToProductsList()
    }

    //Image Slider
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 3000)
    }
    private val runnable = Runnable{
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(50))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY =0.85f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }

    private fun setDataForViewPager2() {
        viewPager2 =findViewById(R.id.view_pager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.mens_clothingcombo1)
        imageList.add(R.drawable.mens_clothingcombo2)
        imageList.add(R.drawable.mens_clothingcombo3)
        imageList.add(R.drawable.mens_clothingcombo4)

        adapter = ImageSliderAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 1
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
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
            "smartphones",
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
        tv_shopnow_mensclothingcombos.setOnClickListener(){
            App.DATA_PRODUCT = "mens-shirts"
            startActivity(Intent(this, CategoryProductsActivity::class.java))
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

    private fun setUpMensCombosData() {
        imgCategory = arrayOf(
            R.drawable.mens_clothingcombo1,
            R.drawable.mens_clothingcombo2,
            R.drawable.mens_clothingcombo3,
            R.drawable.mens_clothingcombo4
        )
        combosArrayList = arrayListOf<Combos>()
        getMensCombosData()
    }

    private fun getMensCombosData() {
        for(i in imgCategory.indices){
            val mensCombos = Combos(imgCategory[i])
            combosArrayList.add(mensCombos)
        }
        mens_combos.adapter = ImageMensCombosAdapter(this@MainActivity, combosArrayList)
    }

    private fun moveToProductsList() {
        tv_seeAll.setOnClickListener(){
            App.DATA_PRODUCT = "smartphones"
            startActivity(Intent(this, CategoryProductsActivity::class.java))
        }
        tv_seeAll_suggested.setOnClickListener(){
            App.DATA_PRODUCT = "laptops"
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