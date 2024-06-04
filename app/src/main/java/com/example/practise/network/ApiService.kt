package com.example.practise.network

import android.telecom.Call
import com.example.practise.model.data.Item
import retrofit2.http.GET

interface ApiService {
    @GET("leaderboard.json")
    suspend fun getItems(): Item
}