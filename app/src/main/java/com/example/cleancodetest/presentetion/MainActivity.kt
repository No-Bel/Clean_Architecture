package com.example.cleancodetest.presentetion

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitectureapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("AAA", "Activity Created")
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