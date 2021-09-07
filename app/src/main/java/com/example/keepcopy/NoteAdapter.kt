package com.example.keepcopy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.keepcopy.database.Note

class NoteAdapter: ListAdapter<Note, NoteVH>(NoteComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item_layout, parent, false)
        return NoteVH(view)
    }

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.bind(getItem(position))
    }
}

class NoteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.note_title)
    val detail: TextView = itemView.findViewById(R.id.note_details)

    fun bind(note: Note) {
        title.text = note.noteTitle
        detail.text = note.note

    }

}
class NoteComparator : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

}