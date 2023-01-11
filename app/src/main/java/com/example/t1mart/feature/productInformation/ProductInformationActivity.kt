package com.example.t1mart.feature.productInformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import com.example.t1mart.R
import com.example.t1mart.api.product.apiProductInterface
import com.example.t1mart.api.productInformation.apiProductInformationInterface
import com.example.t1mart.extension.App
import com.example.t1mart.feature.categoryProducts.adapter.ProductsAdapter
import com.example.t1mart.feature.productInformation.adapter.ImageAdapter
import com.example.t1mart.feature.productInformation.adapter.ProductInformationAdapter
import com.example.t1mart.feature.productInformation.adapter.ProductInformationTruthAdapter
import kotlinx.android.synthetic.main.activity_category_products.*
import kotlinx.android.synthetic.main.activity_product_information.*
import kotlinx.android.synthetic.main.activity_product_information.img_back
import quicktype.Product
import quicktype.Total
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.NullPointerException

class ProductInformationActivity : AppCompatActivity() {
    val BASE_URL = "https://dummyjson.com/"
    lateinit var data: Total
    lateinit var dataProductInformation : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_information)
        getSmartPhoneInformationData()
        //setUpProductInformationData()
        setUpSimilarProductsList()
        backToProductsList()
    }

    private fun setUpProductInformationData() {
        when(App.DATA_PRODUCT){
            "smartphones"-> getSmartPhoneInformationData()
            else ->
                Toast.makeText(this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getSmartPhoneInformationData() {
        val retrofitBuilder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInformationInterface::class.java)

        val retrofitData = intent.getStringExtra("index")
            ?.let { retrofitBuilder.getDataSmartphoneInformation(it) }
        d("tung", "${retrofitData}")
        retrofitData?.enqueue(object : Callback<Product?> {
            override fun onResponse(call:
                                    Call<Product?>,
                                    response: Response<Product?>) {
                val responseBody = response!!.body()!!
                dataProductInformation = responseBody
                list_productInformation.adapter = ProductInformationTruthAdapter(
                    this@ProductInformationActivity,
                    responseBody
                )
                list_item_image.adapter = ImageAdapter(this@ProductInformationActivity, responseBody.images!!)
            }

            override fun onFailure(call: Call<Product?>, t: Throwable) {
                Log.d("Deptrai", ""+t.message)
            }
        })
    }

    private fun setUpSimilarProductsList() {
        when(App.DATA_PRODUCT){
            "smartphones"-> getSmartPhonesData()
            "laptops"-> getLaptopsData()
            "fragrances"-> getFragrancesData()
            "skincare"-> getSkinCareData()
            "groceries"-> getGroceriesData()
            "home-decoration"-> getHomeDecorationData()
            "furniture"-> getFurnitureData()
            "tops"-> getTopData()
            "womens-dresses"-> getWomenDressesData()
            "womens-shoes"-> getWomenShoesData()
            "mens-shirts"-> getMenShirtData()
            "mens-shoes"-> getMenShoesData()
            "mens-watches"-> getMenWatchesData()
            "womens-watches"-> getWomenWatchesData()
            "womens-bags"-> getWomenBagsData()
            "womens-jewellery"-> getWomenJewelleryData()
            "sunglasses"-> getSunglassesData()
            "automotive"-> getAutomativeData()
            "motorcycle"-> getMotorcycleData()
            "lighting"-> getLightingData()
            else ->
                Toast.makeText(this, "Lỗi dữ liệu", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSmartPhonesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataSmartphone()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getLaptopsData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataLaptop()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getFragrancesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataFragrances()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getSkinCareData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataSkinCare()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getGroceriesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataGroceries()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getHomeDecorationData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataHomeDecoration()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getFurnitureData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataFurniture()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getTopData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataTops()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomenDressesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataWomenDresses()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomenShoesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataWomenShoes()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMenShirtData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataMenShirts()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMenShoesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataMenShoes()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMenWatchesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataMenWatches()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomenWatchesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataWomenWatches()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomenBagsData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataWomenBags()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getWomenJewelleryData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataWomenJewellery()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getSunglassesData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataSunglasses()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getAutomativeData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataAutomotive()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getMotorcycleData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataMotorcycle()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }
    private fun getLightingData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiProductInterface::class.java)
        val retrofitData = retrofitBuilder.getDataLighting()
        retrofitData.enqueue(object : Callback<Total?> {
            override fun onResponse(call:
                                    Call<Total?>,
                                    response: Response<Total?>) {
                var responseBody = response!!.body()!!
                data = responseBody
                list_similarProduct.adapter = ProductInformationAdapter(this@ProductInformationActivity, data.products!!)
            }

            override fun onFailure(call: Call<Total?>, t: Throwable) {
                Log.d("Khoa", "" + t.message)
            }
        })
    }

    private fun backToProductsList() {
        img_back.setOnClickListener(){
            onBackPressed()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}