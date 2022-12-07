package com.example.cleancodetest.presentetion

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitectureapp.databinding.ActivityMainBinding
import com.example.cleancodetest.data.repository.UserRepositoryImpl
import com.example.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.cleancodetest.domain.usecase.SaveUserNameUseCase
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("AAA", "Activity Created", )
        viewModel = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]
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