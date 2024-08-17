package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//THIS ADAPTER IS FOR "COLORFUL BACKGROUND OF SAVED NOTES"

class NotesAdapter(private val notes: List<String>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val colors = listOf(
        R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        // Set the text
        holder.noteText.text = notes[position]

        // Set the background color
        val colorRes = colors[position % colors.size]
        holder.cardView.setCardBackgroundColor(holder.itemView.context.getColor(colorRes))
    }

    override fun getItemCount(): Int = notes.size

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.card_view)
        val noteText: TextView = itemView.findViewById(R.id.note_text)
    }
}
