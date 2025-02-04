package com.example.eslami.UI.Home.Hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.databinding.ItemHadethLineBinding

class HadethContentAdapter(private val hadethLines: List<String>) :
    RecyclerView.Adapter<HadethContentAdapter.HadethContentViewHolder>() {
    class HadethContentViewHolder(val binding: ItemHadethLineBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethContentViewHolder {
        return HadethContentViewHolder(
            binding = ItemHadethLineBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount() = hadethLines.size

    override fun onBindViewHolder(holder: HadethContentViewHolder, position: Int) {
        holder.binding.hadethLineContent.text = hadethLines[position]
    }


}