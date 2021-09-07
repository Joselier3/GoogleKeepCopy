package com.example.keepcopy

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter {
}

class NoteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.note_title)
    val detail: TextView = itemView.findViewById(R.id.note_details)

    fun bind() {

    }

}
class NoteComparator() {

}