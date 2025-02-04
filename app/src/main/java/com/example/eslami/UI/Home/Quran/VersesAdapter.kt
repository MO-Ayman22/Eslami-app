package com.example.eslami.UI.Home.Quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.R

class VersesAdapter(private val verses: List<String>) :
    RecyclerView.Adapter<VersesAdapter.VersesViewHolder>() {
    class VersesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val verseTextView: TextView = itemView.findViewById(R.id.verse_content)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_verse, parent, false)
        return VersesViewHolder(view)
    }

    override fun getItemCount() = verses.size

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        holder.verseTextView.text = verses[position] + "(${position + 1})"
    }

}