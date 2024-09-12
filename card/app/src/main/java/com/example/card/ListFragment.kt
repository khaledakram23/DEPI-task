package com.example.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.card.databinding.FragmentListBinding
import com.example.card.databinding.ItemCardBinding
import com.example.myapplication.MyAdapter


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
     lateinit var itemList: MutableList<UserData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemList = mutableListOf()


        addDataInList()

        binding.myList.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MyAdapter(itemList){
            itemList->
            findNavController().navigate(R.id.detailsFragment, bundleOf(
                "name" to itemList.name,
                "gender" to itemList.gender,
                "city" to itemList.city
            ))
        }
        binding.myList.adapter = adapter
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentListBinding.inflate(layoutInflater,container,false)

        return binding.root
    }
    private fun addDataInList() {
        itemList.add(UserData(id = 0, name = "Ahmed", email = "ahmed@mail.com", phone = "010339024", city = "Cairo", gender = "male"))
        itemList.add(UserData(id = 1, name = "Sara", email = "sara@mail.com", phone = "0123456789", city = "Alexandria", gender = "female"))
        itemList.add(UserData(id = 2, name = "Omar", email = "omar@mail.com", phone = "0112233445", city = "Giza", gender = "male"))
        itemList.add(UserData(id = 3, name = "Nour", email = "nour@mail.com", phone = "0109988776", city = "Mansoura", gender = "female"))
        itemList.add(UserData(id = 4, name = "Youssef", email = "youssef@mail.com", phone = "0156677889", city = "Aswan", gender = "male"))
        itemList.add(UserData(id = 5, name = "Laila", email = "laila@mail.com", phone = "0153344556", city = "Luxor", gender = "female"))
        itemList.add(UserData(id = 6, name = "Hassan", email = "hassan@mail.com", phone = "0121122334", city = "Fayoum", gender = "male"))
        itemList.add(UserData(id = 7, name = "Mona", email = "mona@mail.com", phone = "0115566778", city = "Port Said", gender = "female"))
    }

}