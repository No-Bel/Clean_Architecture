package com.example.cleancodetest.presentetion

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitectureapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.resultLive.observe(this) {
            binding.dataTv.text = it
        }

        binding.saveBtn.setOnClickListener {
            val text = binding.dataEt.text.toString()
            viewModel.save(text)
        }

        binding.receiveBtn.setOnClickListener {
            viewModel.load()
        }
    }
}