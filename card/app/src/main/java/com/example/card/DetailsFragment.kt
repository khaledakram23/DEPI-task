package com.example.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.card.databinding.FragmentDetailsBinding
import com.example.card.databinding.FragmentListBinding


class DetailsFragment : Fragment() {
    lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.text=arguments?.getString("name","").toString()
        binding.city.text=arguments?.getString("city","").toString()
        binding.gender.text=arguments?.getString("gender","").toString()

    }

}