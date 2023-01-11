package com.example.t1mart.api.productInformation

import quicktype.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface apiProductInformationInterface{
    @GET("products/{index}")
    fun getDataSmartphoneInformation(
        @Path("index") index: String
    ) : Call<Product>
}