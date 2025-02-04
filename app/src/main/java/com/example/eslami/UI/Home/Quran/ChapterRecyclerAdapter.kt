package com.example.eslami.UI.Home.Quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.R

class ChapterRecyclerAdapter(
    private val chapters: List<String>,
    private val listener: OnChapterClickListener
) : RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = chapters[position]
        holder.itemView.setOnClickListener {
            listener.onItemClick(position, chapters[position])
        }

    }
}