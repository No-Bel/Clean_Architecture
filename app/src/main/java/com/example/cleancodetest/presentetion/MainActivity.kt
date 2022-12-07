package com.example.cleancodetest.presentetion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitectureapp.databinding.ActivityMainBinding
import com.example.cleancodetest.data.repository.UserRepositoryImpl
import com.example.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.cleancodetest.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext)) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendBtn.setOnClickListener {
            val text = binding.dataEt.text.toString()
            val param = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = param)
            binding.dataTv.text = "Save result = $result"
        }

        binding.receiveBtn.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            binding.dataTv.text = "${userName.firstName}"
        }
    }
}