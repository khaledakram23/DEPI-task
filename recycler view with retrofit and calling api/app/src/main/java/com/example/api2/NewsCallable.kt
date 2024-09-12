package com.example.api2

import retrofit2.Call
import retrofit2.http.GET

interface NewsCallable {
    @GET("/v2/top-headlines?country=us&category=general&apiKey=facf4a784c754ac9b8c583983a8531f0&pageSize=30")
    fun getNews(): Call<News>
}