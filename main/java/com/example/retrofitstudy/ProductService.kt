package com.example.retrofitstudy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class Product(var id:Int,var title:String, val description:String, val discountPercentage:String)

interface ProductService {
    @GET("/products/{id}")
    fun getProduct(@Path("id") id: Int) : Call<Product>
}