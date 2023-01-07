package com.example.t1mart.api.product

import quicktype.Total
import retrofit2.Call
import retrofit2.http.GET

interface apiProductInterface {
    @GET("products/category/smartphones")
    fun getDataSmartphone() :Call<Total>

    @GET("products/category/laptops")
    fun getDataLaptop() :Call<Total>

    @GET("products/category/fragrances")
    fun getDataFragrances() :Call<Total>

    @GET("products/category/skincare")
    fun getDataSkinCare() :Call<Total>

    @GET("products/category/groceries")
    fun getDataGroceries() :Call<Total>

    @GET("products/category/home-decoration")
    fun getDataHomeDecoration() :Call<Total>

    @GET("products/category/furniture")
    fun getDataFurniture() :Call<Total>

    @GET("products/category/tops")
    fun getDataTops() :Call<Total>

    @GET("products/category/womens-dresses")
    fun getDataWomenDresses() :Call<Total>

    @GET("products/category/womens-shoes")
    fun getDataWomenShoes() :Call<Total>

    @GET("products/category/mens-shirts")
    fun getDataMenShirts() :Call<Total>

    @GET("products/category/mens-shoes")
    fun getDataMenShoes() :Call<Total>

    @GET("products/category/mens-watches")
    fun getDataMenWatches() :Call<Total>

    @GET("products/category/womens-watches")
    fun getDataWomenWatches() :Call<Total>

    @GET("products/category/womens-bags")
    fun getDataWomenBags() :Call<Total>

    @GET("products/category/womens-jewellery")
    fun getDataWomenJewellery() :Call<Total>

    @GET("products/category/sunglasses")
    fun getDataSunglasses() :Call<Total>

    @GET("products/category/automotive")
    fun getDataAutomotive() :Call<Total>

    @GET("products/category/motorcycle")
    fun getDataMotorcycle() :Call<Total>

    @GET("products/category/lighting")
    fun getDataLighting() :Call<Total>
}