package com.example.keepcopy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.keepcopy.MainActivity
import com.example.keepcopy.R
import com.example.keepcopy.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add, container, false)
        (requireActivity() as MainActivity).showUpButton()
        return binding.root
    }
    
}