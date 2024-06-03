package com.example.practise.network

import com.example.practise.model.data.Item
import retrofit2.http.GET

interface ApiService {
    @GET("items")
    suspend fun getItems(): List<Item>
}