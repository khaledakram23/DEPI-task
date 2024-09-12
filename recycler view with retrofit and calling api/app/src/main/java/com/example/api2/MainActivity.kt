package com.example.api2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        loadNews()
    }

    private fun setupRecyclerView() {
        binding.newsList.layoutManager = LinearLayoutManager(this) // Set the LayoutManager
    }

    private fun loadNews() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsCallable = retrofit.create(NewsCallable::class.java)
        newsCallable.getNews().enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                val articles = news?.articles ?: arrayListOf()
                Log.d("News", "Articles: $articles")
                showNews(articles)
                binding.progress.isVisible = false
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("News", "Error: ${t.message}")
                binding.progress.isVisible = false
            }
        })
    }

    private fun showNews(articles: ArrayList<Article>) {
        val adapter = NewsAdapter(this, articles)
        binding.newsList.adapter = adapter
    }
}
