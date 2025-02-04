package com.example.eslami.UI.Home.Hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eslami.R
import com.example.eslami.UI.Home.Constants
import com.example.eslami.databinding.FragmentHadethBinding

class HadethFragment : Fragment(), OnHadethClickListener {

    lateinit var binding: FragmentHadethBinding
    lateinit var hadethAdapter: HadethAdapter
    val hadethList = mutableListOf<Hadeth>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHadethBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
        initAdapter()
    }

    private fun initAdapter() {
        hadethAdapter = HadethAdapter(hadethList, this)
        binding.rvAhadeth.adapter = hadethAdapter
        binding.rvAhadeth.layoutManager = LinearLayoutManager(requireContext())
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider)!!)
        binding.rvAhadeth.addItemDecoration(divider)
    }

    fun readHadethFile() {
        val fileContent = requireContext().assets.open("ahadeth.txt")
            .bufferedReader().use { it.readText() }
        val sepratedAhadeth = fileContent.trim().split("#")
        sepratedAhadeth.forEach {
            val hadethLines = it.trim().split("\n").toMutableList()
            val title = hadethLines[0]
            hadethLines.removeAt(0)
            val content = hadethLines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }

    }

    override fun onItemClick(position: Int, hadeth: Hadeth) {
        val intent = Intent(requireContext(), HadethDetailsActivity::class.java)
        intent.putExtra(Constants.TITLE_KEY, hadeth.title)
        intent.putExtra(Constants.CONTENT_KEY, hadeth.content)
        startActivity(intent)
    }
}