package com.example.practise.model.repository

import com.example.practise.model.data.Item
import com.example.practise.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemRepository {
    private val BASE_URL = "https://run.mocky.io/v3/c0e9340a-a66e-47bf-8dd2-47a7182d22c5/"
    // https://run.mocky.io/v3/c0e9340a-a66e-47bf-8dd2-47a7182d22c5/

    // Retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // ApiService instance
    val apiService = retrofit.create(ApiService::class.java)

    // Function to fetch items from the API
    suspend fun getItems(): List<Item> {
        return withContext(Dispatchers.IO) {
            // Make API call using Retrofit
            apiService.getItems()
        }
    }
}