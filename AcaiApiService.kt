package com.example.acaiStore.network

import retrofit2.Call
import retrofit2.http.GET

// Supondo que a API retorne uma lista de produtos
interface AcaiApiService {
    @GET("/products")
    fun getProducts(): Call<List<AcaiProduct>>
}
