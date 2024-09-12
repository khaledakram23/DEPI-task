package com.example.card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.card.databinding.ActivityMainBinding
import com.example.myapplication.MyAdapter

class MainActivity : AppCompatActivity() {
    lateinit var itemList: MutableList<UserData>


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the data list

    }

    // Function to add data to the list

}
