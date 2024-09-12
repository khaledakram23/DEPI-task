package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.card.UserData
import com.example.card.databinding.ItemCardBinding

class MyAdapter(private val itemList: List<UserData>,val onItemClick :(UserData)->Unit) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


     inner class MyViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userData: UserData) {
            binding.root.setOnClickListener{
                onItemClick (userData)
            }
            binding.name.text = userData.name
            binding.mail.text = userData.email
            binding.phone.text = userData.phone
            binding.city.text = userData.city
            binding.gender.text = userData.gender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
        
    }

    override fun getItemCount() = itemList.size
}
