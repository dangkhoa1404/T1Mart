package com.example.t1mart.feature.categoryProducts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import com.example.t1mart.R
import com.example.t1mart.api.product.apiProductInterface
import com.example.t1mart.extension.App
import com.example.t1mart.feature.categories.CategoriesActivity
import com.example.t1mart.feature.categoryProducts.adapter.ProductsAdapter
import com.example.t1mart.feature.productInformation.ProductInformationActivity
import kotlinx.android.synthetic.main.activity_category_products.*
import quicktype.Total
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CategoryProductsActivity : AppCompatActivity(), ProductsAdapter.onItemClickListener {

    val BASE_URL = "https://dummyjson.com/"
    private lateinit var productAdapter : ProductsAdapter
    lateinit var data: Total
    private lateinit var productArrayList : ArrayList<Total>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_products)
        productArrayList = arrayListOf<Total>()
        setUpProductsList()
        //searchProductData()
        backToPreviousActivity()
    }

    private fun getProductData() {

    }

    private fun setUpProductsList() {
        when(App.DATA_PRODUCT){
            "smartphones"-> getSmartPhonesData()
            "laptops"-> getLaptopsData()
            "fragrances"-> getFragrancesData()
            "skincare"-> getSkinCareData()
            "groceries"-> getGroceriesData()
            "home-decoration"-> getHomeDecorationData()
            "furniture"-> getFurnitureData()
            "tops"-> getTopsData()
            "womens-dresses"-> getWomensDressesData()
            "womens-shoes"-> getWomensShoesData()
            "mens-shirts"-> getMensShirtsData()
            "mens-shoes"-> getMenShoessData()
            "mens-watches"-> getMensWatchesData()
            "womens-watches"-> getWomensWatchesData()
            "womens-bags"-> getWomensBagsData()
            "womens-jewellery"-> getWomensJewellryData()
            "sunglasses"-> getSunglassesData()
            "automotive"-> getAutomativeData()
            "motorcycle"-> getMotorcycleData()
            "lighting"-> getLightingData()
            else ->
                Toast.makeText(this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSmartPhonesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataSmartphone()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getLaptopsData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataLaptop()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getFragrancesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataFragrances()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getSkinCareData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataSkinCare()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getGroceriesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataGroceries()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getHomeDecorationData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataHomeDecoration()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getFurnitureData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataFurniture()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getTopsData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataTops()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomensDressesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataWomenDresses()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomensShoesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataWomenShoes()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMensShirtsData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataMenShirts()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMenShoessData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataMenShoes()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMensWatchesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataMenWatches()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomensWatchesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataWomenWatches()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomensBagsData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataWomenBags()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomensJewellryData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataWomenJewellery()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getSunglassesData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataSunglasses()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getAutomativeData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataAutomotive()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMotorcycleData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataMotorcycle()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getLightingData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)

        val retrofitData = retrofitBuilder.getDataLighting()
        d("tung", "${retrofitData}")
        retrofitData.enqueue(object : Callback<Total> {
            override fun onResponse(call:
                                    Call<Total>?, response: Response<Total>?) {
                val responseBody = response!!.body()!!
                data = responseBody
                list_categories.adapter = ProductsAdapter(this@CategoryProductsActivity, data.products!!, this@CategoryProductsActivity)
            }

            override fun onFailure(call: Call<Total>?, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }

    private fun backToPreviousActivity() {
        img_back.setOnClickListener(){
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onItemClick(index: String) {
        val intent = Intent(this, ProductInformationActivity::class.java)
        intent.putExtra("index", index)
        startActivity(intent)
//        Log.d("Category", "${App.DATA_PRODUCT}")
    }
}