package com.example.keepcopy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.keepcopy.database.Note
import com.example.keepcopy.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        binding.btnDrawer.setOnClickListener {
            (activity as MainActivity).openDrawer()
        }
        binding.notesList.adapter = NoteAdapter()
        (binding.notesList.adapter as NoteAdapter).submitList(getData())
        return binding.root
    }

    private fun getData(): List<Note> {
        return listOf(
            Note(0, "Note 1", "Hello there",0),
            Note(0, "Note 2", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 3", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 1", "Hello there",0),
            Note(0, "Note 2", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 3", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 1", "Hello there",0),
            Note(0, "Note 2", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 3", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 1", "Hello there",0),
            Note(0, "Note 2", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 3", "Hello thereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeee",0),
            Note(0, "Note 4", "Hello thereeeeeeeeeeeeeeeeeeeeee",0),

        )
    }


}