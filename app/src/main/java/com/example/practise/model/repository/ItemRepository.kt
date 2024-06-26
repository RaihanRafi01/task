package com.example.practise.model.repository

import com.example.practise.model.data.Item
import com.example.practise.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemRepository {
    private val BASE_URL = "https://raw.githubusercontent.com/mhasancse17/JsonFile/main/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(ApiService::class.java)

    suspend fun getItems(): Item {
        return withContext(Dispatchers.IO) {
            apiService.getItems()
        }
    }

}