package com.example.cleancodetest.presentetion

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitectureapp.databinding.ActivityMainBinding
import com.example.cleancodetest.app.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity Created")
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
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