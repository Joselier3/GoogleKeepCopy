package com.example.keepcopy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.keepcopy.MainActivity
import com.example.keepcopy.NoteAdapter
import com.example.keepcopy.R
import com.example.keepcopy.database.NoteRoomDatabase
import com.example.keepcopy.databinding.FragmentHomeBinding
import com.example.keepcopy.viewmodels.KeepCopyViewModel
import com.example.keepcopy.viewmodels.KeepCopyViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private val viewModel: KeepCopyViewModel by viewModels { KeepCopyViewModelFactory(NoteRoomDatabase.getDatabase(requireContext()).noteDao())}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        binding.btnDrawer.setOnClickListener { (activity as MainActivity).openDrawer() }
        (requireActivity() as MainActivity).hideUpButton()
        navController = findNavController()
        setAdapter()
        navigateToAddFragment()
        return binding.root
    }

    private fun setAdapter() {
        binding.notesList.adapter = NoteAdapter()
        lifecycle.coroutineScope.launch {
            viewModel.getAllNotes().collect { notes ->
                (binding.notesList.adapter as NoteAdapter).submitList(notes)
            }
        }
    }

    private fun navigateToAddFragment() {
        binding.fabAdd.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_addFragment)
        }
    }


}