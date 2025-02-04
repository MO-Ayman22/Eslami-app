package com.example.eslami.UI.Home.Hadeth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eslami.UI.Home.Constants
import com.example.eslami.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var adapter: HadethContentAdapter
    lateinit var binding: ActivityHadethDetailsBinding
    lateinit var hadethLines: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(Constants.TITLE_KEY)
        val content = intent.getStringExtra(Constants.CONTENT_KEY)
        binding.content.hadethTitle.text = title
        hadethLines = content!!.split("\n").toMutableList()
        initAdapter()

    }

    private fun initAdapter() {
        adapter = HadethContentAdapter(hadethLines)
        binding.content.rvHadethLines.adapter = adapter
        binding.content.rvHadethLines.layoutManager = LinearLayoutManager(this)
    }
}