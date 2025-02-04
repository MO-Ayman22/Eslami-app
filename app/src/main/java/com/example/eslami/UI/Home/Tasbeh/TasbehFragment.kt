package com.example.eslami.UI.Home.Tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eslami.R
import com.example.eslami.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var tasbehCounter = 0
    private var tasbehIndex = 0
    private lateinit var tasbehArray: MutableList<String>
    lateinit var binding: FragmentTasbehBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTasbehBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.counter.text = "0"
        tasbehArray = resources.getStringArray(R.array.tasbeh_array).toMutableList()
        binding.butTasbeh.text = tasbehArray[tasbehIndex]
        binding.sebhaBody.setOnClickListener {
            initTasbeh()
        }
    }

    private fun initTasbeh() {
        binding.sebhaBody.rotation += (360 / 33.0).toFloat()
        if (tasbehCounter < 33) {
            binding.counter.text = "${++tasbehCounter}"
        } else {
            binding.counter.text = "0"
            tasbehCounter = 0
            tasbehIndex++
            if (tasbehIndex == tasbehArray.size)
                tasbehIndex = 0
            binding.butTasbeh.text = tasbehArray[tasbehIndex]
            binding.butTasbeh.text = tasbehArray[tasbehIndex]
        }
    }
}