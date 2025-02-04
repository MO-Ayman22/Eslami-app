package com.example.eslami.UI.Home.Quran

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eslami.R
import com.example.eslami.UI.Home.Constants
import com.example.eslami.databinding.ActivityChapterDetailsBinding

class ChapterDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChapterDetailsBinding
    private lateinit var chapterTitle: String
    private lateinit var adapter: VersesAdapter
    private var chapterPosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chapterTitle = intent.getStringExtra(Constants.TITLE_KEY) ?: ""
        chapterPosition = intent.getIntExtra(Constants.POSITION_KEY, 0)
        initViews()
    }

    private fun initViews() {
        binding.content.chapterTitle.text = " سورة $chapterTitle"
        adapter = VersesAdapter(readChapterFile())
        binding.content.rvVerses.adapter = adapter
        binding.content.rvVerses.layoutManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider)!!)
        binding.content.rvVerses.addItemDecoration(divider)
    }

    fun readChapterFile(): List<String> {
        val chapterContent = assets.open("${chapterPosition + 1}.txt")
            .bufferedReader().use { it.readText() }
        return chapterContent.split("\n")
    }

}