package com.example.eslami.UI.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.eslami.R
import com.example.eslami.UI.Home.Hadeth.HadethFragment
import com.example.eslami.UI.Home.Quran.QuranFragment
import com.example.eslami.UI.Home.Radio.RadioFragment
import com.example.eslami.UI.Home.Tasbeh.TasbehFragment
import com.example.eslami.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showTab(QuranFragment())
        binding.content.bottomNavigation.selectedItemId = R.id.quran
        binding.content.bottomNavigation.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.radio -> showTab(RadioFragment())
                R.id.hadeth -> showTab(HadethFragment())
                R.id.sebha -> showTab(TasbehFragment())
                R.id.quran -> showTab(QuranFragment())
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showTab(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}