package com.example.eslami.UI.Home.Hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eslami.databinding.ItemHadethBinding

class HadethAdapter(
    private val hadethList: List<Hadeth>,
    private val listener: OnHadethClickListener
) : RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {
    class HadethViewHolder(val binding: ItemHadethBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        return HadethViewHolder(
            binding = ItemHadethBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = hadethList.size

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        holder.binding.hadethTitle.text = "الحديث رقم (${position + 1})"
        holder.binding.root.setOnClickListener {
            listener.onItemClick(position, hadethList[position])
        }

    }

}