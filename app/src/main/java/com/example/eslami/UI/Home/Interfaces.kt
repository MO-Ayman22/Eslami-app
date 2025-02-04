package com.example.eslami.UI.Home

import com.example.eslami.UI.Home.Hadeth.Hadeth

interface OnItemClickListener {
    fun onItemClick(position: Int, title: String)
}

interface OnHadethClickListener {
    fun onItemClick(position: Int, hadeth: Hadeth)
}