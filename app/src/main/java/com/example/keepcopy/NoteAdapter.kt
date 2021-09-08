package com.example.keepcopy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.keepcopy.database.FinalNote
import com.example.keepcopy.database.Note

class NoteAdapter: ListAdapter<FinalNote, NoteVH>(NoteComparator()) {
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

    fun bind(note: FinalNote) {
        title.text = note.noteTitle
        detail.text = note.note

    }

}
class NoteComparator : DiffUtil.ItemCallback<FinalNote>() {
    override fun areItemsTheSame(oldItem: FinalNote, newItem: FinalNote): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FinalNote, newItem: FinalNote): Boolean {
        return oldItem.id == newItem.id
    }

}